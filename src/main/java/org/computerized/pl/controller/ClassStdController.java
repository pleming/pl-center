package org.computerized.pl.controller;

import org.computerized.pl.model.ClassStdDelVO;
import org.computerized.pl.model.ClassStdVO;
import org.computerized.pl.model.ClassVO;
import org.computerized.pl.model.ResponseVO;
import org.computerized.pl.service.ClassService;
import org.computerized.pl.service.ClassStdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("class/std")
public class ClassStdController {
    @Autowired
    private ClassStdService classStdService;

    @RequestMapping(value = "loadStudentInClass", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO loadClassById(@RequestBody ClassStdVO classStdVO) {
        return new ResponseVO(true, 1, classStdService.loadStudentInClass(classStdVO.getClassId()));
    }

    @RequestMapping(value = "delStudentInClass", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO delStudentInClass(@RequestBody ClassStdDelVO classStdDelVO) {
        classStdService.delStudentInClass(classStdDelVO);
        return new ResponseVO(true, 1, "학생 삭제를 성공하였습니다.");
    }
}
