package org.computerized.pl.controller;

import org.computerized.pl.model.classStd.StdSearchVO;
import org.computerized.pl.model.classStd.StudentVO;
import org.computerized.pl.model.general.ResponseVO;
import org.computerized.pl.model.general.SearchKeyVO;
import org.computerized.pl.model.paging.PagingInfoVO;
import org.computerized.pl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "dashboard", method = {RequestMethod.GET})
    public void renderDashboard() {
    }

    @RequestMapping(value = "counsel", method = {RequestMethod.GET})
    public void renderCounsel() {
    }

    @RequestMapping(value = "loadStudent", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO loadStudent(@RequestBody PagingInfoVO pagingInfoVO) {
        List<StudentVO> studentVOList = userService.loadStudent(pagingInfoVO.getPagingInfo());
        Integer totalRowCount = userService.getTotalRowCount();

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("userList", studentVOList);
        res.put("totalRowCount", totalRowCount);

        return new ResponseVO(true, 1, res);
    }

    @RequestMapping(value = "searchStudent", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO searchStudent(@RequestBody SearchKeyVO searchKeyVO) {
        List<StudentVO> studentVOList = userService.searchStudent(searchKeyVO.getSearchKey(), searchKeyVO.getPagingInfo());
        Integer totalRowCount = userService.getTotalRowCountForSearch(searchKeyVO.getSearchKey());

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("userList", studentVOList);
        res.put("totalRowCount", totalRowCount);

        return new ResponseVO(true, 1, res);
    }

    @RequestMapping(value = "loadStudentByCondition", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO loadStudent(@RequestBody Map<String, Object> param) {
        List<StdSearchVO> stdSearchVOList = userService.loadStudentByCondition(param);
        return new ResponseVO(true, 1, stdSearchVOList);
    }
}
