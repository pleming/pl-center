package org.computerized.pl.controller;

import org.computerized.pl.model.ClassVO;
import org.computerized.pl.model.ResponseVO;
import org.computerized.pl.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @RequestMapping(value = "loadClass", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseVO loadClass() {
        return new ResponseVO(true, 1, classService.loadClass());
    }

    @RequestMapping(value = "loadClassById", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO loadClassById(@RequestBody Map<String, Object> param) {
        return new ResponseVO(true, 1, classService.loadClassById((Integer)param.get("id")));
    }

    @RequestMapping(value = "addClass", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO addClass(@RequestBody ClassVO classVO) {
        classService.addClass(classVO);
        return new ResponseVO(true, 1, classService.loadClass());
    }

    @RequestMapping(value = "modClass", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO modClass(@RequestBody ClassVO classVO) {
        classService.modClass(classVO);
        return new ResponseVO(true, 1, "분반 수정을 성공하였습니다.");
    }
}
