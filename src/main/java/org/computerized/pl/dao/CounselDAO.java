package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.model.CounselAddVO;
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

    public void addCounsel(CounselAddVO counselAddVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("userCode", counselAddVO.getUserCode());
        param.put("counselContents", counselAddVO.getCounselContents());

        sqlSession.insert("counsel.addCounsel", param);
    }

    public void delCounsel(Integer counselId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("counselId", counselId);
        sqlSession.insert("counsel.delCounsel", param);
    }
}
