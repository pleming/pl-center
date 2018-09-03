package org.computerized.pl.controller;

import org.computerized.pl.model.ResponseVO;
import org.computerized.pl.service.ColDeptService;
import org.computerized.pl.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("colDept")
public class ColDeptController {
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private ColDeptService colDeptService;

    @RequestMapping(value = "loadCollege", method = {RequestMethod.GET})
    @ResponseBody
    public ResponseVO loadCollege() {
        return new ResponseVO(true, 1, collegeService.loadCollege());
    }

    @RequestMapping(value = "loadDept", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO loadDept(@RequestBody Map<String, Object> param) {
        return new ResponseVO(true, 1, colDeptService.loadDeptListByColId((Integer)param.get("colId")));
    }
}
