package org.computerized.pl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("error")
public class ErrorController {
    @RequestMapping(value = "400", method = { RequestMethod.GET })
    public void error400() {}

    @RequestMapping(value = "404", method = { RequestMethod.GET })
    public void error404() {}
}
