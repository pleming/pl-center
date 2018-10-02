package org.computerized.pl.service;

import org.computerized.pl.dao.WorkingDiaryDAO;
import org.computerized.pl.model.WorkingDiaryAddListVO;
import org.computerized.pl.model.WorkingDiaryForAdminVO;
import org.computerized.pl.model.WorkingDiarySearchVO;
import org.computerized.pl.model.WorkingDiaryVO;
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

    public List<WorkingDiaryForAdminVO> loadWorkingDiaryForAdmin() {
        return workingDiaryDAO.loadWorkingDiaryForAdmin();
    }

    public List<WorkingDiaryForAdminVO> searchWorkingDiary(WorkingDiarySearchVO workingDiarySearchVO) {
        return workingDiaryDAO.searchWorkingDiary(workingDiarySearchVO);
    }

    public void addWorkingDiary(WorkingDiaryAddListVO workingDiaryAddListVO) {
        workingDiaryDAO.addWorkingDiary(workingDiaryAddListVO);
    }

    public void attendWorker(WorkingDiaryVO workingDiaryVO) {
        workingDiaryDAO.attendWorker(workingDiaryVO);
    }
}
