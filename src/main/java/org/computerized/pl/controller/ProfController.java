package org.computerized.pl.controller;

import org.computerized.pl.model.ClassVO;
import org.computerized.pl.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("prof")
public class ProfController {
    @Autowired
    private ClassService classService;

    @RequestMapping(value = "dashboard", method = { RequestMethod.GET })
    public void renderDashboard() {}

    @RequestMapping(value = "class", method = { RequestMethod.GET })
    public void renderClass() {}

    @RequestMapping(value = "class/add", method = { RequestMethod.GET })
    public void renderAdd() {}

    @RequestMapping(value = "class/mod/{classId}", method = { RequestMethod.GET })
    public ModelAndView renderMod(@PathVariable long classId) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("classId", classId);
        mav.setViewName("prof/class/mod");

        return mav;
    }
}
