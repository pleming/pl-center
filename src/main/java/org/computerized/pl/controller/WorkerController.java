package org.computerized.pl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("worker")
public class WorkerController {
    @RequestMapping(value = "dashboard", method = { RequestMethod.GET })
    public void renderDashboard(){}
}
