package org.computerized.pl.controller;

import org.computerized.pl.code.CodeDefinition;
import org.computerized.pl.model.general.ResponseVO;
import org.computerized.pl.model.general.SessionVO;
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
    public ResponseVO loadSuggestionList(@RequestBody PagingVO pagingVO) {
        List<SuggestionListVO> suggestionListVOList = suggestionService.loadSuggestionList(pagingVO);
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
    public ResponseVO searchSuggestion(@RequestBody Map<String, Object> param) {
        String searchKey = (String) param.get("searchKey");
        List<SuggestionListVO> suggestionListVOList = suggestionService.searchSuggestion(searchKey);
        return new ResponseVO(true, 1, suggestionListVOList);
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
