package org.computerized.pl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("prof")
public class ProfController {
    @RequestMapping(value = "dashboard", method = { RequestMethod.GET })
    public void renderDashboard() {}

    @RequestMapping(value = "class", method = { RequestMethod.GET })
    public void renderClass() {}

    @RequestMapping(value = "class/add", method = { RequestMethod.GET })
    public void renderAdd() {}
}
