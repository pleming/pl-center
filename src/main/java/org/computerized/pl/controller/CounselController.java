package org.computerized.pl.controller;

import org.computerized.pl.model.counsel.CounselAddListVO;
import org.computerized.pl.model.counsel.CounselAddVO;
import org.computerized.pl.model.counsel.CounselSearchVO;
import org.computerized.pl.model.counsel.CounselVO;
import org.computerized.pl.model.general.IdListVO;
import org.computerized.pl.model.general.ResponseVO;
import org.computerized.pl.model.general.SessionVO;
import org.computerized.pl.model.paging.PagingInfoVO;
import org.computerized.pl.model.paging.PagingVO;
import org.computerized.pl.service.CounselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("counsel")
public class CounselController {
    @Autowired
    private CounselService counselService;

    @RequestMapping(value = "loadCounsel", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO loadCounsel(@RequestBody PagingInfoVO pagingInfoVO) {
        List<CounselVO> counselVOList = counselService.loadCounsel(pagingInfoVO.getPagingInfo());
        Integer totalRowCount = counselService.getTotalRowCount();

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("counselList", counselVOList);
        res.put("totalRowCount", totalRowCount);

        return new ResponseVO(true, 1, res);
    }

    @RequestMapping(value = "loadCounselByCondition", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO loadCounselByCondition(@RequestBody CounselSearchVO counselSearchVO) {
        List<CounselVO> counselVOList = counselService.loadCounselByCondition(counselSearchVO);
        Integer totalRowCount = counselService.getTotalRowCountForSearch(counselSearchVO);

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("counselList", counselVOList);
        res.put("totalRowCount", totalRowCount);

        return new ResponseVO(true, 1, res);
    }

    @RequestMapping(value = "addCounsel", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO addCounsel(HttpSession httpSession, @RequestBody CounselAddListVO counselAddListVO) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        List<CounselAddVO> counselAddList = counselAddListVO.getCounselAddList();

        for (int i = 0; i < counselAddList.size(); i++)
            counselAddList.get(i).setCounselorUserCode(sessionVO.getUserCode());

        counselService.addCounsel(counselAddListVO);

        return new ResponseVO(true, 1, "상담일지 추가를 성공하였습니다.");
    }

    @RequestMapping(value = "delCounsel", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVO delCounsel(@RequestBody IdListVO idListVO) {
        counselService.delCounsel(idListVO);
        return new ResponseVO(true, 1, "상담일지 삭제를 성공하였습니다.");
    }

    @RequestMapping(value = "loadPlCertificated", method = {RequestMethod.GET})
    @ResponseBody
    public ResponseVO loadPlCertificated(HttpSession httpSession) {
        SessionVO sessionVO = (SessionVO) httpSession.getAttribute("sessionInfo");
        Integer userCode = sessionVO.getUserCode();

        List<CounselVO> counselVOList = counselService.loadPlCertificated(userCode);

        return new ResponseVO(true, 1, counselVOList);
    }
}
