package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.model.CounselAddListVO;
import org.computerized.pl.model.CounselIdListVO;
import org.computerized.pl.model.CounselSearchVO;
import org.computerized.pl.model.CounselVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CounselDAO {
    @Autowired
    private SqlSession sqlSession;

    public List<CounselVO> loadCounsel() {
        return sqlSession.selectList("counsel.loadCounsel");
    }

    public List<CounselVO> loadCounselByCondition(CounselSearchVO counselSearchVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("year", counselSearchVO.getYear());
        param.put("semester", counselSearchVO.getSemester());
        param.put("classNo", counselSearchVO.getClassNo());
        param.put("searchKey", "%" + counselSearchVO.getSearchKey() + "%");

        return sqlSession.selectList("counsel.loadCounselByCondition", param);
    }

    public void addCounsel(CounselAddListVO counselAddListVO) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("counselAddList", counselAddListVO.getCounselAddList());
        sqlSession.insert("counsel.addCounsel", param);
    }

    public void delCounsel(CounselIdListVO counselIdListVO) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("counselList", counselIdListVO.getCounselIdList());
        sqlSession.insert("counsel.delCounsel", param);
    }
}
