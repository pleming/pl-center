package org.computerized.pl.controller;

import org.computerized.pl.model.AuthVO;
import org.computerized.pl.model.ResponseVO;
import org.computerized.pl.model.StudentVO;
import org.computerized.pl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "dashboard", method = { RequestMethod.GET })
    public void renderDashboard(){}

    @RequestMapping(value = "auth")
    public void renderAuth(){}

    @RequestMapping(value = "loadStudent", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseVO loadStudent() {
        List<StudentVO> studentVOList = userService.loadStudent();
        return new ResponseVO(true, 1, studentVOList);
    }

    @RequestMapping(value = "updateAuth", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO updateAuth(@RequestBody AuthVO authVO) {
        userService.updateAuth(authVO);
        return new ResponseVO(true, 1, "권한 변경을 성공하였습니다.");
    }
}
