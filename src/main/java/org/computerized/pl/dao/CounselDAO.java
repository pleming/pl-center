package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.model.CounselVO;
import org.computerized.pl.model.CounselSearchVO;
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
}
