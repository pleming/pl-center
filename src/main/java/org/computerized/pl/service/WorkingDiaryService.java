package org.computerized.pl.service;

import org.computerized.pl.dao.WorkingDiaryDAO;
import org.computerized.pl.model.general.IdListVO;
import org.computerized.pl.model.paging.PagingVO;
import org.computerized.pl.model.workingDiary.WorkingDiaryAddListVO;
import org.computerized.pl.model.workingDiary.WorkingDiaryForAdminVO;
import org.computerized.pl.model.workingDiary.WorkingDiarySearchVO;
import org.computerized.pl.model.workingDiary.WorkingDiaryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingDiaryService {
    @Autowired
    private WorkingDiaryDAO workingDiaryDAO;

    public List<WorkingDiaryVO> loadWorkingDiary(String nowYearMonth) {
        return workingDiaryDAO.loadWorkingDiary(nowYearMonth);
    }

    public List<WorkingDiaryForAdminVO> loadWorkingDiaryForAdmin(PagingVO pagingVO) {
        return workingDiaryDAO.loadWorkingDiaryForAdmin(pagingVO);
    }

    public Integer getTotalRowCount() {
        return workingDiaryDAO.getTotalRowCount();
    }

    public List<WorkingDiaryForAdminVO> searchWorkingDiary(WorkingDiarySearchVO workingDiarySearchVO) {
        return workingDiaryDAO.searchWorkingDiary(workingDiarySearchVO);
    }

    public Integer getTotalRowCountForSearch(WorkingDiarySearchVO workingDiarySearchVO) {
        return workingDiaryDAO.getTotalRowCountForSearch(workingDiarySearchVO);
    }

    public void addWorkingDiary(WorkingDiaryAddListVO workingDiaryAddListVO) {
        workingDiaryDAO.addWorkingDiary(workingDiaryAddListVO);
    }

    public void delWorkingDiary(IdListVO idListVO) {
        workingDiaryDAO.deldWorkingDiary(idListVO);
    }

    public void attendWorker(WorkingDiaryVO workingDiaryVO) {
        workingDiaryDAO.attendWorker(workingDiaryVO);
    }
}
