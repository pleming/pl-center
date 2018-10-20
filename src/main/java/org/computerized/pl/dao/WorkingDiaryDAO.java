package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.model.general.IdListVO;
import org.computerized.pl.model.paging.PagingVO;
import org.computerized.pl.model.workingDiary.WorkingDiaryAddListVO;
import org.computerized.pl.model.workingDiary.WorkingDiaryForAdminVO;
import org.computerized.pl.model.workingDiary.WorkingDiarySearchVO;
import org.computerized.pl.model.workingDiary.WorkingDiaryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class WorkingDiaryDAO {
    @Autowired
    private SqlSession sqlSession;

    public List<WorkingDiaryVO> loadWorkingDiary(String nowYearMonth) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("nowYearMonth", nowYearMonth);
        return sqlSession.selectList("workingDiary.loadWorkingDiary", param);
    }

    public List<WorkingDiaryForAdminVO> loadWorkingDiaryForAdmin(PagingVO pagingVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("startIdx", (pagingVO.getNowPage() - 1) * pagingVO.getRowPerPage());
        param.put("rowBound", pagingVO.getRowPerPage());

        return sqlSession.selectList("workingDiary.loadWorkingDiaryForAdmin", param);
    }

    public Integer getTotalRowCount() {
        List<Integer> list = sqlSession.selectList("notice.getTotalRowCount");
        return list.get(0);
    }

    public List<WorkingDiaryForAdminVO> searchWorkingDiary(WorkingDiarySearchVO workingDiarySearchVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("startDate", workingDiarySearchVO.getWorkingDiarySearchStartDate());
        param.put("endDate", workingDiarySearchVO.getWorkingDiarySearchEndDate());
        param.put("searchKey", "%" + workingDiarySearchVO.getSearchKey() + "%");

        return sqlSession.selectList("workingDiary.searchWorkingDiary", param);
    }

    public void addWorkingDiary(WorkingDiaryAddListVO workingDiaryAddListVO) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("workingDiaryAddList", workingDiaryAddListVO.getWorkingDiaryAddList());
        sqlSession.insert("workingDiary.addWorkingDiary", param);
    }

    public void deldWorkingDiary(IdListVO idListVO) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("workingDiaryIdList", idListVO.getIdList());
        sqlSession.insert("workingDiary.delWorkingDiary", param);
    }

    public void attendWorker(WorkingDiaryVO workingDiaryVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("userCode", workingDiaryVO.getUserCode());
        param.put("workingStartDatetime", workingDiaryVO.getWorkingStartDatetime());
        param.put("workingEndDatetime", workingDiaryVO.getWorkingEndDatetime());
        param.put("workingContents", workingDiaryVO.getWorkingContents());

        sqlSession.insert("workingDiary.attendWorker", param);
    }
}
