package org.computerized.pl.controller;

import org.computerized.pl.dao.WorkingDiaryDAO;
import org.computerized.pl.model.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("worker")
public class WorkerController {
    @Autowired
    private WorkingDiaryDAO workingDiaryDAO;

    @RequestMapping(value = "dashboard", method = { RequestMethod.GET })
    public void renderDashboard(){}

    @RequestMapping(value = "workingDiary", method = { RequestMethod.GET })
    public void renderWorkingDiary(){}

    @RequestMapping(value = "counsel", method = { RequestMethod.GET })
    public void renderCounsel(){}
}
