package org.computerized.pl.controller;

import org.computerized.pl.code.CodeDefinition;
import org.computerized.pl.model.general.ResponseVO;
import org.computerized.pl.model.general.SessionVO;
import org.computerized.pl.model.notice.NoticeListVO;
import org.computerized.pl.model.notice.NoticePostVO;
import org.computerized.pl.model.notice.NoticeVO;
import org.computerized.pl.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "loadNoticeList", method = {RequestMethod.GET})
    @ResponseBody
    public ResponseVO loadNoticeList() {
        List<NoticeListVO> noticeListVOList = noticeService.loadNoticeList();
        return new ResponseVO(true, 1, noticeListVOList);
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
    public ResponseVO searchNotice(@RequestBody Map<String, Object> param) {
        String searchKey = (String) param.get("searchKey");
        List<NoticeListVO> noticeListVOList = noticeService.searchNotice(searchKey);
        return new ResponseVO(true, 1, noticeListVOList);
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
