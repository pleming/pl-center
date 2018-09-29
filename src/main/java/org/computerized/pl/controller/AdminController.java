package org.computerized.pl.controller;

import org.computerized.pl.model.AuthVO;
import org.computerized.pl.model.ResponseVO;
import org.computerized.pl.model.StdSearchVO;
import org.computerized.pl.model.WorkingDiaryForAdminVO;
import org.computerized.pl.service.UserService;
import org.computerized.pl.service.WorkingDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private WorkingDiaryService workingDiaryService;

    @RequestMapping(value = "dashboard", method = { RequestMethod.GET })
    public void renderDashboard(){}

    @RequestMapping(value = "workingDiary")
    public void renderWorkingDiary(){}

    @RequestMapping(value = "counsel")
    public void renderCounsel(){}

    @RequestMapping(value = "auth")
    public void renderAuth(){}

    @RequestMapping(value = "loadWorkingDiary", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseVO loadWorkingDiary() {
        List<WorkingDiaryForAdminVO> workingDiaryForAdminVOList = workingDiaryService.loadWorkingDiaryForAdmin();
        return new ResponseVO(true, 1, workingDiaryForAdminVOList);
    }

    @RequestMapping(value = "loadStudentForAdmin", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO loadStudent(@RequestBody Map<String, Object> param) {
        List<StdSearchVO> stdSearchVOList = userService.loadStudentForAdmin(param);
        return new ResponseVO(true, 1, stdSearchVOList);
    }

    @RequestMapping(value = "updateAuth", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO updateAuth(@RequestBody AuthVO authVO) {
        userService.updateAuth(authVO);
        return new ResponseVO(true, 1, "권한 변경을 성공하였습니다.");
    }
}
