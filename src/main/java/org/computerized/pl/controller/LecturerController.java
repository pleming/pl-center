package org.computerized.pl.controller;

import org.computerized.pl.model.ClassVO;
import org.computerized.pl.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("lecturer")
public class LecturerController {
    @Autowired
    private ClassService classService;

    @RequestMapping(value = "dashboard", method = { RequestMethod.GET })
    public void renderDashboard() {}

    @RequestMapping(value = "class", method = { RequestMethod.GET })
    public void renderClass() {}

    @RequestMapping(value = "student", method = { RequestMethod.GET })
    public void renderClassStudent() {}

    @RequestMapping(value = "counsel", method = { RequestMethod.GET })
    public void renderCounsel() {}

    @RequestMapping(value = "class/add", method = { RequestMethod.GET })
    public void renderAddClass() {}

    @RequestMapping(value = "class/mod/{classId}", method = { RequestMethod.GET })
    public ModelAndView renderModClass(@PathVariable long classId) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("classId", classId);
        mav.setViewName("lecturer/class/mod");

        return mav;
    }

    @RequestMapping(value = "student/settings/{classId}", method = { RequestMethod.GET })
    public ModelAndView renderSettingStudent(@PathVariable long classId) {
        ModelAndView mav = new ModelAndView();

        ClassVO classVO = classService.loadClassById((int)classId);
        String title = classVO.getYear() + "-" + classVO.getSemester() + "(0" + classVO.getClassNo() + ") 설정";

        mav.addObject("classId", classId);
        mav.addObject("title", title);
        mav.setViewName("lecturer/student/settings");

        return mav;
    }
}
