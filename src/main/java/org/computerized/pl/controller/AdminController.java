package org.computerized.pl.controller;

import org.computerized.pl.model.classStd.StdSearchVO;
import org.computerized.pl.model.colDept.ColDeptAddVO;
import org.computerized.pl.model.colDept.ColDeptDeleteListVO;
import org.computerized.pl.model.colDept.ColDeptIdVO;
import org.computerized.pl.model.colDept.CollegeVO;
import org.computerized.pl.model.counsel.CounselAddForAdminListVO;
import org.computerized.pl.model.general.AuthVO;
import org.computerized.pl.model.general.IdListVO;
import org.computerized.pl.model.general.ResponseVO;
import org.computerized.pl.model.paging.PagingInfoVO;
import org.computerized.pl.model.paging.PagingVO;
import org.computerized.pl.model.workingDiary.WorkingDiaryAddListVO;
import org.computerized.pl.model.workingDiary.WorkingDiaryForAdminVO;
import org.computerized.pl.model.workingDiary.WorkingDiarySearchVO;
import org.computerized.pl.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
    private CounselService counselService;
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private ColDeptService colDeptService;

    @RequestMapping(value = "dashboard", method = {RequestMethod.GET})
    public void renderDashboard() {
    }

    @RequestMapping(value = "workingDiary", method = {RequestMethod.GET})
    public void renderWorkingDiary() {
    }

    @RequestMapping(value = "counsel", method = {RequestMethod.GET})
    public void renderCounsel() {
    }

    @RequestMapping(value = "college", method = {RequestMethod.GET})
    public void renderCollege() {
    }

    @RequestMapping(value = "dept", method = {RequestMethod.GET})
    public void renderDept() {
    }

    @RequestMapping(value = "auth", method = {RequestMethod.GET})
    public void renderAuth() {
    }

    @RequestMapping(value = "loadWorkingDiary", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO loadWorkingDiary(@RequestBody PagingInfoVO pagingInfoVO) {
        List<WorkingDiaryForAdminVO> workingDiaryForAdminVOList = workingDiaryService.loadWorkingDiaryForAdmin(pagingInfoVO.getPagingInfo());
        Integer totalRowCount = workingDiaryService.getTotalRowCount();

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("workingDiaryList", workingDiaryForAdminVOList);
        res.put("totalRowCount", totalRowCount);

        return new ResponseVO(true, 1, res);
    }

    @RequestMapping(value = "searchWorkingDiary", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO searchWorkingDiary(@RequestBody WorkingDiarySearchVO workingDiarySearchVO) {
        List<WorkingDiaryForAdminVO> workingDiaryForAdminVOList = workingDiaryService.searchWorkingDiary(workingDiarySearchVO);
        Integer totalRowCount = workingDiaryService.getTotalRowCountForSearch(workingDiarySearchVO);

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("workingDiaryList", workingDiaryForAdminVOList);
        res.put("totalRowCount", totalRowCount);

        return new ResponseVO(true, 1, res);
    }

    @RequestMapping(value = "loadWorkerForWorkingDiary", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO loadWorkerForWorkingDiary(@RequestBody Map<String, Object> param) {
        List<StdSearchVO> stdSearchVOList = userService.loadWorkerForWorkingDiary(param);
        return new ResponseVO(true, 1, stdSearchVOList);
    }

    @RequestMapping(value = "addWorkingDiary", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO addWorkingDiary(@RequestBody WorkingDiaryAddListVO workingDiaryAddListVO) {
        workingDiaryService.addWorkingDiary(workingDiaryAddListVO);
        return new ResponseVO(true, 1, "근무일지 추가를 성공하였습니다.");
    }

    @RequestMapping(value = "delWorkingDiary", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO delWorkingDiary(@RequestBody IdListVO idListVO) {
        workingDiaryService.delWorkingDiary(idListVO);
        return new ResponseVO(true, 1, "근무일지 삭제를 성공하였습니다.");
    }

    @RequestMapping(value = "loadWorker", method = {RequestMethod.GET})
    @ResponseBody
    public ResponseVO loadWorker() {
        return new ResponseVO(true, 1, userService.loadWorker());
    }

    @RequestMapping(value = "addCounselForAdmin", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO addCounselForAdmin(@RequestBody CounselAddForAdminListVO counselAddForAdminListVO) {
        counselService.addCounselForAdmin(counselAddForAdminListVO);
        return new ResponseVO(true, 1, "상담일지 추가를 성공하였습니다.");
    }

    @RequestMapping(value = "addCollege", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO addCollege(@RequestBody CollegeVO collegeVO) {
        collegeService.addCollege(collegeVO);
        return new ResponseVO(true, 1, "단과대학 추가를 성공하였습니다.");
    }

    @RequestMapping(value = "delCollege", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO delCollege(@RequestBody IdListVO idListVO) {
        collegeService.delCollege(idListVO);
        return new ResponseVO(true, 1, "단과대학 삭제를 성공하였습니다.");
    }

    @RequestMapping(value = "addDept", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO addDept(@RequestBody ColDeptAddVO colDeptAddVO) {
        colDeptService.addDept(colDeptAddVO.getDeptName());
        colDeptService.mappingColDept(colDeptAddVO.getCollegeId());
        return new ResponseVO(true, 1, "학과 추가를 성공하였습니다.");
    }

    @RequestMapping(value = "delDept", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO delDept(@RequestBody ColDeptDeleteListVO colDeptDeleteListVO) {
        List<ColDeptIdVO> colDeptIdVOList = colDeptDeleteListVO.getColDeptIdList();

        colDeptService.delDept(colDeptIdVOList);
        colDeptService.removeMappingColDept(colDeptIdVOList);

        return new ResponseVO(true, 1, "학과 삭제를 성공하였습니다.");
    }

    @RequestMapping(value = "updateAuth", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO updateAuth(@RequestBody AuthVO authVO) {
        userService.updateAuth(authVO);
        return new ResponseVO(true, 1, "권한 변경을 성공하였습니다.");
    }
}
