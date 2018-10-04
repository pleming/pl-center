package org.computerized.pl.controller;

import org.computerized.pl.model.*;
import org.computerized.pl.service.CollegeService;
import org.computerized.pl.service.UserService;
import org.computerized.pl.service.WorkingDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private WorkingDiaryService workingDiaryService;
    @Autowired
    private CollegeService collegeService;

    @RequestMapping(value = "dashboard", method = { RequestMethod.GET })
    public void renderDashboard(){}

    @RequestMapping(value = "workingDiary")
    public void renderWorkingDiary(){}

    @RequestMapping(value = "counsel")
    public void renderCounsel(){}

    @RequestMapping(value = "college")
    public void renderCollege(){}

    @RequestMapping(value = "dept")
    public void renderDept(){}

    @RequestMapping(value = "auth")
    public void renderAuth(){}

    @RequestMapping(value = "loadWorkingDiary", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseVO loadWorkingDiary() {
        List<WorkingDiaryForAdminVO> workingDiaryForAdminVOList = workingDiaryService.loadWorkingDiaryForAdmin();
        return new ResponseVO(true, 1, workingDiaryForAdminVOList);
    }

    @RequestMapping(value = "searchWorkingDiary", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO searchWorkingDiary(@RequestBody WorkingDiarySearchVO workingDiarySearchVO) {
        List<WorkingDiaryForAdminVO> workingDiaryForAdminVOList = workingDiaryService.searchWorkingDiary(workingDiarySearchVO);
        return new ResponseVO(true, 1, workingDiaryForAdminVOList);
    }

    @RequestMapping(value = "loadStudentForAdmin", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO loadStudent(@RequestBody Map<String, Object> param) {
        List<StdSearchVO> stdSearchVOList = userService.loadStudentForAdmin(param);
        return new ResponseVO(true, 1, stdSearchVOList);
    }

    @RequestMapping(value = "addWorkingDiary", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO addWorkingDiary(@RequestBody WorkingDiaryAddListVO workingDiaryAddListVO) {
        workingDiaryService.addWorkingDiary(workingDiaryAddListVO);
        return new ResponseVO(true, 1, "근무일지 추가를 성공하였습니다.");
    }

    @RequestMapping(value = "delWorkingDiary", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO delWorkingDiary(@RequestBody IdListVO idListVO) {
        workingDiaryService.delWorkingDiary(idListVO);
        return new ResponseVO(true, 1, "근무일지 삭제를 성공하였습니다.");
    }

    @RequestMapping(value = "addCollege", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO addCollege(@RequestBody CollegeVO collegeVO) {
        collegeService.addCollege(collegeVO);
        return new ResponseVO(true, 1, "단과대학 추가를 성공하였습니다.");
    }

    @RequestMapping(value = "delCollege", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO delCollege(@RequestBody IdListVO idListVO) {
        collegeService.delCollege(idListVO);
        return new ResponseVO(true, 1, "단과대학 삭제를 성공하였습니다.");
    }

    @RequestMapping(value = "updateAuth", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO updateAuth(@RequestBody AuthVO authVO) {
        userService.updateAuth(authVO);
        return new ResponseVO(true, 1, "권한 변경을 성공하였습니다.");
    }
}
