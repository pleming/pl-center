package org.computerized.pl.controller;

import org.computerized.pl.code.CodeDefinition;
import org.computerized.pl.model.SessionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MainController {
    @RequestMapping(value = "", method = { RequestMethod.GET })
    public String renderIndex(HttpSession httpSession) {
        SessionVO sessionVO = (SessionVO)httpSession.getAttribute("sessionInfo");

        Integer auth = sessionVO.getAuth();

        if(auth.equals(CodeDefinition.Auth.STUDENT.getCode()))
            return "redirect:/student/dashboard";
        else if(auth.equals(CodeDefinition.Auth.WORKER.getCode()))
            return "redirect:/worker/dashboard";
        else if(auth.equals(CodeDefinition.Auth.LECTURER.getCode()))
            return "redirect:/lecturer/dashboard";
        else if(auth.equals(CodeDefinition.Auth.ADMIN.getCode()))
            return "redirect:/admin/dashboard";
        else
            return "redirect:/error/400";
    }
}
