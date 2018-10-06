package org.computerized.pl.controller;

import org.computerized.pl.model.general.ResponseVO;
import org.computerized.pl.model.general.SessionVO;
import org.computerized.pl.model.workingDiary.WorkingDiaryVO;
import org.computerized.pl.service.WorkingDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("worker")
public class WorkerController {
    @Autowired
    private WorkingDiaryService workingDiaryService;

    @RequestMapping(value = "dashboard", method = { RequestMethod.GET })
    public void renderDashboard(){}

    @RequestMapping(value = "workingDiary", method = { RequestMethod.GET })
    public void renderWorkingDiary(){}

    @RequestMapping(value = "counsel", method = { RequestMethod.GET })
    public void renderCounsel(){}

    @RequestMapping(value = "loadWorkingDiary", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO loadWorkingDiary(@RequestBody Map<String, Object> param) {
        String nowYearMonth = param.get("nowYearMonth").toString();
        List<WorkingDiaryVO> workingDiaryVOList = workingDiaryService.loadWorkingDiary(nowYearMonth);
        return new ResponseVO(true, 1, workingDiaryVOList);
    }

    @RequestMapping(value = "attendWorker", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO attendWorker(HttpSession httpSession, @RequestBody WorkingDiaryVO workingDiaryVO) {
        SessionVO sessionVO = (SessionVO)httpSession.getAttribute("sessionInfo");

        Integer userCode = sessionVO.getUserCode();
        workingDiaryVO.setUserCode(userCode);

        workingDiaryService.attendWorker(workingDiaryVO);

        return new ResponseVO(true, 1, "정상 출근 되었습니다.");
    }
}
