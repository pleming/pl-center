package org.computerized.pl.service;

import org.computerized.pl.dao.WorkingDiaryDAO;
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

    public void attendWorker(WorkingDiaryVO workingDiaryVO) {
        workingDiaryDAO.attendWorker(workingDiaryVO);
    }
}
