package org.computerized.pl.controller;

import org.computerized.pl.code.CodeDefinition;
import org.computerized.pl.model.general.ResponseVO;
import org.computerized.pl.model.general.SessionVO;
import org.computerized.pl.model.notice.NoticeListVO;
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

    @RequestMapping(value = "list", method = { RequestMethod.GET })
    public ModelAndView renderNotice(HttpSession httpSession, ModelAndView mav) {
        setSidebarPath(httpSession, mav, "notice/list");
        return mav;
    }

    @RequestMapping(value = "view/{noticeId}", method = { RequestMethod.GET })
    public ModelAndView renderNoticeView(HttpSession httpSession, ModelAndView mav, @PathVariable long noticeId) {
        setSidebarPath(httpSession, mav, "notice/view");
        mav.addObject("noticeId", noticeId);
        return mav;
    }

    @RequestMapping(value = "loadNoticeList", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseVO loadNoticeList() {
        List<NoticeListVO> noticeListVOList = noticeService.loadNoticeList();
        return new ResponseVO(true, 1, noticeListVOList);
    }

    @RequestMapping(value = "loadNoticeById", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO loadNoticeById(@RequestBody Map<String, Object> param) {
        Integer noticeId = (Integer)param.get("noticeId");
        NoticeVO noticeVO = noticeService.loadNoticeById(noticeId);
        return new ResponseVO(true, 1, noticeVO);
    }

    private void setSidebarPath(HttpSession httpSession, ModelAndView mav, String viewName) {
        SessionVO sessionVO = (SessionVO)httpSession.getAttribute("sessionInfo");
        Integer auth = sessionVO.getAuth();
        String sidebarPath = null;

        switch(auth) {
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
}
