package org.computerized.pl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("assistant")
public class AssistantController {
    @RequestMapping(value = "dashboard", method = { RequestMethod.GET })
    public void renderDashboard(){}
}
