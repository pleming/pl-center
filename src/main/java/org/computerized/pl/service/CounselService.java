package org.computerized.pl.service;

import org.computerized.pl.dao.CounselDAO;
import org.computerized.pl.model.CounselAddListVO;
import org.computerized.pl.model.CounselIdListVO;
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

    public void addCounsel(CounselAddListVO counselAddListVO) {
        counselDAO.addCounsel(counselAddListVO);
    }

    public void delCounsel(CounselIdListVO counselIdListVO) {
        counselDAO.delCounsel(counselIdListVO);
    }

    public List<CounselVO> loadPlCertificated(Integer userCode) {
        return counselDAO.loadPlCertificated(userCode);
    }
}
