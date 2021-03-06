package org.computerized.pl.controller;

import org.computerized.pl.code.CodeDefinition;
import org.computerized.pl.model.comment.CommentVO;
import org.computerized.pl.model.general.IdListVO;
import org.computerized.pl.model.general.ResponseVO;
import org.computerized.pl.model.general.SearchKeyVO;
import org.computerized.pl.model.general.SessionVO;
import org.computerized.pl.model.notice.NoticeListVO;
import org.computerized.pl.model.notice.NoticePostVO;
import org.computerized.pl.model.notice.NoticeVO;
import org.computerized.pl.model.paging.PagingInfoVO;
import org.computerized.pl.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "list", method = {RequestMethod.GET})
    public ModelAndView renderNotice(HttpSession httpSession, ModelAndView mav) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");

        setSidebarPath(httpSession, mav, "notice/list");
        mav.addObject("isAdmin", sessionVO.getAuth().equals(CodeDefinition.Auth.ADMIN.getCode()));

        return mav;
    }

    @RequestMapping(value = "view/{noticeId}", method = {RequestMethod.GET})
    public ModelAndView renderNoticeView(HttpSession httpSession, ModelAndView mav, @PathVariable long noticeId) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer userCode = sessionVO.getUserCode();

        setSidebarPath(httpSession, mav, "notice/view");

        NoticeVO noticeVO = noticeService.loadNoticeById((int) noticeId);
        noticeService.increaseViews((int) noticeId);

        boolean isExistAuth = noticeVO.getWriterUserCode().equals(userCode);

        mav.addObject("noticeId", noticeId);
        mav.addObject("isExistAuth", isExistAuth);
        mav.addObject("isAdmin", sessionVO.getAuth().equals(CodeDefinition.Auth.ADMIN.getCode()));

        return mav;
    }

    @RequestMapping(value = "add", method = {RequestMethod.GET})
    public ModelAndView renderNoticeAdd(HttpSession httpSession, ModelAndView mav) {
        setSidebarPath(httpSession, mav, "notice/add");
        return mav;
    }

    @RequestMapping(value = "mod/{noticeId}", method = {RequestMethod.GET})
    public ModelAndView renderNoticeMod(HttpSession httpSession, ModelAndView mav, @PathVariable long noticeId) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer userCode = sessionVO.getUserCode();

        setSidebarPath(httpSession, mav, "notice/mod");

        if (!checkAuth(noticeId, userCode)) {
            mav.setViewName("/error/400");
            return mav;
        }

        mav.addObject("noticeId", noticeId);

        return mav;
    }

    @RequestMapping(value = "loadNoticeList", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO loadNoticeList(@RequestBody PagingInfoVO pagingInfoVO) {
        List<NoticeListVO> noticeListVOList = noticeService.loadNoticeList(pagingInfoVO.getPagingInfo());
        Integer totalRowCount = noticeService.getTotalRowCount();

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("noticeList", noticeListVOList);
        res.put("totalRowCount", totalRowCount);

        return new ResponseVO(true, 1, res);
    }

    @RequestMapping(value = "loadNoticeById", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO loadNoticeById(@RequestBody Map<String, Object> param) {
        Integer noticeId = (Integer) param.get("noticeId");
        NoticeVO noticeVO = noticeService.loadNoticeById(noticeId);
        return new ResponseVO(true, 1, noticeVO);
    }

    @RequestMapping(value = "add", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO addNotice(HttpSession httpSession, @RequestBody NoticePostVO noticePostVO) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");

        if (!sessionVO.getAuth().equals(CodeDefinition.Auth.ADMIN.getCode()))
            return new ResponseVO(true, 1, "게시글 등록 권한이 없습니다.");

        noticePostVO.setWriter(sessionVO.getUserCode());

        noticeService.addNotice(httpSession, noticePostVO);

        return new ResponseVO(true, 1, "게시글 등록을 성공하였습니다.");
    }

    @RequestMapping(value = "mod/{noticeId}", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO modNotice(HttpSession httpSession, @RequestBody NoticePostVO noticePostVO, @PathVariable long noticeId) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer userCode = sessionVO.getUserCode();

        if (!checkAuth(noticeId, userCode))
            return new ResponseVO(true, 1, "게시글 수정 권한이 없습니다.");

        noticePostVO.setNoticeId((int) noticeId);
        noticePostVO.setWriter(sessionVO.getUserCode());
        noticeService.modNotice(httpSession, noticePostVO);

        return new ResponseVO(true, 1, "게시글 수정을 성공하였습니다.");
    }

    @RequestMapping(value = "del/{noticeId}", method = {RequestMethod.GET})
    @ResponseBody
    public ResponseVO delNotice(HttpSession httpSession, @PathVariable long noticeId) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer userCode = sessionVO.getUserCode();

        if (!checkAuth(noticeId, userCode))
            return new ResponseVO(true, 1, "게시글 삭제 권한이 없습니다.");

        NoticePostVO noticePostVO = new NoticePostVO();
        noticePostVO.setNoticeId((int) noticeId);

        noticeService.delNotice(httpSession, noticePostVO);

        return new ResponseVO(true, 2, "게시글 삭제를 성공하였습니다.");
    }

    @RequestMapping(value = "search", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO searchNotice(@RequestBody SearchKeyVO searchKeyVO) {
        List<NoticeListVO> noticeListVOList = noticeService.searchNotice(searchKeyVO.getSearchKey(), searchKeyVO.getPagingInfo());
        Integer totalRowCount = noticeService.getTotalRowCountForSearch(searchKeyVO.getSearchKey());

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("noticeList", noticeListVOList);
        res.put("totalRowCount", totalRowCount);

        return new ResponseVO(true, 1, res);
    }

    @RequestMapping(value = "loadComment", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO loadComment(HttpSession httpSession, @RequestBody Map<String, Object> param) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer noticeId = (Integer) param.get("noticeId");
        List<CommentVO> commentVOList = noticeService.loadComment(noticeId);

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("commentList", commentVOList);
        res.put("userCode", sessionVO.getUserCode());

        return new ResponseVO(true, 1, res);
    }

    @RequestMapping(value = "addComment", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO addComment(HttpSession httpSession, @RequestBody CommentVO commentVO) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");

        commentVO.setWriterId(sessionVO.getUserCode());
        noticeService.addComment(commentVO);

        return new ResponseVO(true, 1, "댓글 등록을 성공하였습니다.");
    }

    @RequestMapping(value = "modComment", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO modComment(HttpSession httpSession, @RequestBody CommentVO commentVO) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        CommentVO commentInfo = noticeService.loadCommentById(commentVO.getId());

        if (commentInfo == null)
            return new ResponseVO(true, 1, "수정할 댓글이 존재하지 않습니다.");

        if (!commentInfo.getWriterId().equals(sessionVO.getUserCode()))
            return new ResponseVO(true, 2, "댓글 수정 권한이 존재하지 않습니다.");

        noticeService.modComment(commentVO);

        return new ResponseVO(true, 3, "댓글 수정을 성공하였습니다.");
    }

    @RequestMapping(value = "delComment", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO delComment(HttpSession httpSession, @RequestBody IdListVO idListVO) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer commentId = idListVO.getIdList().get(0);

        CommentVO commentVO = noticeService.loadCommentById(commentId);

        if (commentVO == null)
            return new ResponseVO(true, 1, "삭제할 댓글이 존재하지 않습니다.");

        if (!commentVO.getWriterId().equals(sessionVO.getUserCode()))
            return new ResponseVO(true, 2, "댓글 삭제 권한이 존재하지 않습니다.");

        noticeService.delComment(commentId);

        return new ResponseVO(true, 3, "댓글 삭제를 성공하였습니다.");
    }

    private void setSidebarPath(HttpSession httpSession, ModelAndView mav, String viewName) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer auth = sessionVO.getAuth();
        String sidebarPath = null;

        switch (auth) {
            case 0:
                sidebarPath = CodeDefinition.SidebarPath.STUDENT.getPath();
                break;
            case 1:
                sidebarPath = CodeDefinition.SidebarPath.WORKER.getPath();
                break;
            case 2:
                sidebarPath = CodeDefinition.SidebarPath.LECTURER.getPath();
                break;
            case 3:
                sidebarPath = CodeDefinition.SidebarPath.ADMIN.getPath();
                break;
        }

        mav.addObject("sidebarPath", sidebarPath);
        mav.setViewName(viewName);
    }

    private boolean checkAuth(long noticeId, Integer userCode) {
        NoticeVO noticeVO = noticeService.loadNoticeById((int) noticeId);
        return noticeVO.getWriterUserCode().equals(userCode);
    }
}
