package org.computerized.pl.service;

import org.computerized.pl.dao.CounselDAO;
import org.computerized.pl.model.counsel.CounselAddForAdminListVO;
import org.computerized.pl.model.counsel.CounselAddListVO;
import org.computerized.pl.model.counsel.CounselSearchVO;
import org.computerized.pl.model.counsel.CounselVO;
import org.computerized.pl.model.general.IdListVO;
import org.computerized.pl.model.paging.PagingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounselService {
    @Autowired
    private CounselDAO counselDAO;

    public List<CounselVO> loadCounsel(PagingVO pagingVO) {
        return counselDAO.loadCounsel(pagingVO);
    }

    public Integer getTotalRowCount() {
        return counselDAO.getTotalRowCount();
    }

    public List<CounselVO> loadCounselByCondition(CounselSearchVO counselSearchVO) {
        return counselDAO.loadCounselByCondition(counselSearchVO);
    }

    public Integer getTotalRowCountForSearch(CounselSearchVO counselSearchVO) {
        return counselDAO.getTotalRowCountForSearch(counselSearchVO);
    }

    public void addCounsel(CounselAddListVO counselAddListVO) {
        counselDAO.addCounsel(counselAddListVO);
    }

    public void addCounselForAdmin(CounselAddForAdminListVO counselAddForAdminListVO) {
        counselDAO.addCounselForAdmin(counselAddForAdminListVO);
    }

    public void delCounsel(IdListVO idListVO) {
        counselDAO.delCounsel(idListVO);
    }

    public List<CounselVO> loadPlCertificated(Integer userCode) {
        return counselDAO.loadPlCertificated(userCode);
    }
}
