package org.computerized.pl.controller;

import org.computerized.pl.model.*;
import org.computerized.pl.service.CounselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("counsel")
public class CounselController {
    @Autowired
    private CounselService counselService;

    @RequestMapping(value = "loadCounsel", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseVO loadCounsel() {
        List<CounselVO> counselVOList = counselService.loadCounsel();
        return new ResponseVO(true, 1, counselVOList);
    }

    @RequestMapping(value = "loadCounselByCondition", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO loadCounselByCondition(@RequestBody CounselSearchVO counselSearchVO) {
        List<CounselVO> counselVOList = null;
        counselVOList = counselService.loadCounselByCondition(counselSearchVO);
        return new ResponseVO(true, 1, counselVOList);
    }

    @RequestMapping(value = "addCounsel", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO addCounsel(@RequestBody CounselAddListVO counselAddListVO) {
        counselService.addCounsel(counselAddListVO);
        return new ResponseVO(true, 1, "상담일지 등록을 성공하였습니다.");
    }

    @RequestMapping(value = "delCounsel", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseVO delCounsel(@RequestBody CounselIdListVO counselIdListVO) {
        counselService.delCounsel(counselIdListVO);
        return new ResponseVO(true, 1, "상담일지 삭제를 성공하였습니다.");
    }
}
