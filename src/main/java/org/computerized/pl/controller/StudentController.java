package org.computerized.pl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {
    @RequestMapping(value = "dashboard")
    public void renderDashboard(){}
}
