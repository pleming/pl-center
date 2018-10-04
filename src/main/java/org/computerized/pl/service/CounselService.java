package org.computerized.pl.service;

import org.computerized.pl.dao.CounselDAO;
import org.computerized.pl.model.*;
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

    public void delCounsel(IdListVO idListVO) {
        counselDAO.delCounsel(idListVO);
    }

    public List<CounselVO> loadPlCertificated(Integer userCode) {
        return counselDAO.loadPlCertificated(userCode);
    }
}
