package org.computerized.pl.controller;

import org.computerized.pl.model.ResponseVO;
import org.computerized.pl.model.StdSearchVO;
import org.computerized.pl.model.StudentVO;
import org.computerized.pl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private UserService userService;
    @Autowired

    @RequestMapping(value = "dashboard", method = { RequestMethod.GET })
    public void renderDashboard(){}

    @RequestMapping(value = "loadStudent", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseVO loadStudent() {
        List<StudentVO> studentVOList = userService.loadStudent();
        return new ResponseVO(true, 1, studentVOList);
    }

    @RequestMapping(value = "loadStudentByCondition", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO loadStudent(@RequestBody Map<String, Object> param) {
        String searchKey = param.get("searchKey").toString();
        List<StdSearchVO> stdSearchVOList = userService.loadStudentCondition(searchKey);
        return new ResponseVO(true, 1, stdSearchVOList);
    }
}
