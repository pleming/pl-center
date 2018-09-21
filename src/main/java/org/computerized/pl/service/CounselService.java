package org.computerized.pl.service;

import org.computerized.pl.dao.CounselDAO;
import org.computerized.pl.model.CounselAddVO;
import org.computerized.pl.model.CounselSearchVO;
import org.computerized.pl.model.CounselVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounselService {
    @Autowired
    private CounselDAO counselDAO;

    public List<CounselVO> loadCounsel() {
        return counselDAO.loadCounsel();
    }

    public List<CounselVO> loadCounselByCondition(CounselSearchVO counselSearchVO) {
        return counselDAO.loadCounselByCondition(counselSearchVO);
    }

    public void addCounsel(CounselAddVO counselAddVO) {
        counselDAO.addCounsel(counselAddVO);
    }

    public void delCounsel(Integer counselId) {
        counselDAO.delCounsel(counselId);
    }
}
