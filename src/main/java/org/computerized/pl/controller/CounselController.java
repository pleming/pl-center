package org.computerized.pl.controller;

import org.computerized.pl.model.CounselSearchVO;
import org.computerized.pl.model.CounselVO;
import org.computerized.pl.model.ResponseVO;
import org.computerized.pl.service.CounselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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

        if(counselSearchVO.getYear() == -1 && counselSearchVO.getSemester() == -1 && counselSearchVO.getClassNo() == -1 && counselSearchVO.getSearchKey().equals(""))
            counselVOList = new ArrayList<CounselVO>();
        else
            counselVOList = counselService.loadCounselByCondition(counselSearchVO);

        return new ResponseVO(true, 1, counselVOList);
    }
}
