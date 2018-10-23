package org.computerized.pl.controller;

import org.computerized.pl.code.CodeDefinition;
import org.computerized.pl.model.comment.CommentVO;
import org.computerized.pl.model.general.IdListVO;
import org.computerized.pl.model.general.ResponseVO;
import org.computerized.pl.model.general.SearchKeyVO;
import org.computerized.pl.model.general.SessionVO;
import org.computerized.pl.model.paging.PagingInfoVO;
import org.computerized.pl.model.paging.PagingVO;
import org.computerized.pl.model.suggestion.SuggestionListVO;
import org.computerized.pl.model.suggestion.SuggestionPostVO;
import org.computerized.pl.model.suggestion.SuggestionVO;
import org.computerized.pl.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("suggestion")
public class SuggestionController {
    @Autowired
    private SuggestionService suggestionService;

    @RequestMapping(value = "list", method = {RequestMethod.GET})
    public ModelAndView renderSuggestion(HttpSession httpSession, ModelAndView mav) {
        setSidebarPath(httpSession, mav, "suggestion/list");
        return mav;
    }

    @RequestMapping(value = "view/{suggestionId}", method = {RequestMethod.GET})
    public ModelAndView renderSuggestionView(HttpSession httpSession, ModelAndView mav, @PathVariable long suggestionId) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer userCode = sessionVO.getUserCode();

        setSidebarPath(httpSession, mav, "suggestion/view");

        SuggestionVO suggestionVO = suggestionService.loadSuggestionById((int) suggestionId);
        suggestionService.increaseViews((int) suggestionId);

        boolean isExistAuth = suggestionVO.getWriterUserCode().equals(userCode);

        mav.addObject("suggestionId", suggestionId);
        mav.addObject("isExistAuth", isExistAuth);

        return mav;
    }

    @RequestMapping(value = "add", method = {RequestMethod.GET})
    public ModelAndView renderSuggestionAdd(HttpSession httpSession, ModelAndView mav) {
        setSidebarPath(httpSession, mav, "suggestion/add");
        return mav;
    }

    @RequestMapping(value = "mod/{suggestionId}", method = {RequestMethod.GET})
    public ModelAndView renderSuggestionMod(HttpSession httpSession, ModelAndView mav, @PathVariable long suggestionId) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer userCode = sessionVO.getUserCode();

        setSidebarPath(httpSession, mav, "suggestion/mod");

        if (!checkAuth(suggestionId, userCode)) {
            mav.setViewName("/error/400");
            return mav;
        }

        mav.addObject("suggestionId", suggestionId);

        return mav;
    }

    @RequestMapping(value = "loadSuggestionList", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO loadSuggestionList(@RequestBody PagingInfoVO pagingInfoVO) {
        List<SuggestionListVO> suggestionListVOList = suggestionService.loadSuggestionList(pagingInfoVO.getPagingInfo());
        Integer totalRowCount = suggestionService.getTotalRowCount();

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("suggestionList", suggestionListVOList);
        res.put("totalRowCount", totalRowCount);

        return new ResponseVO(true, 1, res);
    }

    @RequestMapping(value = "loadSuggestionById", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO loadSuggestionById(@RequestBody Map<String, Object> param) {
        Integer suggestionId = (Integer) param.get("suggestionId");
        SuggestionVO suggestionVO = suggestionService.loadSuggestionById(suggestionId);
        return new ResponseVO(true, 1, suggestionVO);
    }

    @RequestMapping(value = "add", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO addSuggestion(HttpSession httpSession, @RequestBody SuggestionPostVO suggestionPostVO) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        suggestionPostVO.setWriter(sessionVO.getUserCode());

        suggestionService.addSuggestion(httpSession, suggestionPostVO);

        return new ResponseVO(true, 1, "게시글 등록을 성공하였습니다.");
    }

    @RequestMapping(value = "mod/{suggestionId}", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO modSuggestion(HttpSession httpSession, @RequestBody SuggestionPostVO suggestionPostVO, @PathVariable long suggestionId) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer userCode = sessionVO.getUserCode();

        if (!checkAuth(suggestionId, userCode))
            return new ResponseVO(true, 1, "게시글 수정 권한이 없습니다.");

        suggestionPostVO.setSuggestionId((int) suggestionId);
        suggestionPostVO.setWriter(sessionVO.getUserCode());
        suggestionService.modSuggestion(httpSession, suggestionPostVO);

        return new ResponseVO(true, 1, "게시글 수정을 성공하였습니다.");
    }

    @RequestMapping(value = "del/{suggestionId}", method = {RequestMethod.GET})
    @ResponseBody
    public ResponseVO delSuggestion(HttpSession httpSession, @PathVariable long suggestionId) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer userCode = sessionVO.getUserCode();

        if (!checkAuth(suggestionId, userCode))
            return new ResponseVO(true, 1, "게시글 삭제 권한이 없습니다.");

        SuggestionPostVO suggestionPostVO = new SuggestionPostVO();
        suggestionPostVO.setSuggestionId((int) suggestionId);

        suggestionService.delSuggestion(httpSession, suggestionPostVO);

        return new ResponseVO(true, 2, "게시글 삭제를 성공하였습니다.");
    }

    @RequestMapping(value = "search", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO searchSuggestion(@RequestBody SearchKeyVO searchKeyVO) {
        List<SuggestionListVO> suggestionListVOList = suggestionService.searchSuggestion(searchKeyVO.getSearchKey(), searchKeyVO.getPagingInfo());
        Integer totalRowCount = suggestionService.getTotalRowCountForSearch(searchKeyVO.getSearchKey());

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("suggestionList", suggestionListVOList);
        res.put("totalRowCount", totalRowCount);

        return new ResponseVO(true, 1, res);
    }

    @RequestMapping(value = "loadComment", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO loadComment(HttpSession httpSession, @RequestBody Map<String, Object> param) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer suggestionId = (Integer) param.get("suggestionId");
        List<CommentVO> commentVOList = suggestionService.loadComment(suggestionId);

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
        suggestionService.addComment(commentVO);

        return new ResponseVO(true, 1, "댓글 등록을 성공하였습니다.");
    }

    @RequestMapping(value = "modComment", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO modComment(HttpSession httpSession, @RequestBody CommentVO commentVO) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        CommentVO commentInfo = suggestionService.loadCommentById(commentVO.getId());

        if (commentInfo == null)
            return new ResponseVO(true, 1, "수정할 댓글이 존재하지 않습니다.");

        if (!commentInfo.getWriterId().equals(sessionVO.getUserCode()))
            return new ResponseVO(true, 2, "댓글 수정 권한이 존재하지 않습니다.");

        suggestionService.modComment(commentVO);

        return new ResponseVO(true, 3, "댓글 수정을 성공하였습니다.");
    }

    @RequestMapping(value = "delComment", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO delComment(HttpSession httpSession, @RequestBody IdListVO idListVO) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer commentId = idListVO.getIdList().get(0);

        CommentVO commentVO = suggestionService.loadCommentById(commentId);

        if (commentVO == null)
            return new ResponseVO(true, 1, "삭제할 댓글이 존재하지 않습니다.");

        if (!commentVO.getWriterId().equals(sessionVO.getUserCode()))
            return new ResponseVO(true, 2, "댓글 삭제 권한이 존재하지 않습니다.");

        suggestionService.delComment(commentId);

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

    private boolean checkAuth(long suggestionId, Integer userCode) {
        SuggestionVO suggestionVO = suggestionService.loadSuggestionById((int) suggestionId);
        return suggestionVO.getWriterUserCode().equals(userCode);
    }
}
