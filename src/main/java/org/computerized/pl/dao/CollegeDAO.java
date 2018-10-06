package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.model.colDept.CollegeVO;
import org.computerized.pl.model.general.IdListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CollegeDAO {
    @Autowired
    private SqlSession sqlSession;

    public List<CollegeVO> loadCollege() {
        return sqlSession.selectList("college.loadCollege");
    }

    public void addCollege(CollegeVO collegeVO) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("collegeName", collegeVO.getCollege());
        sqlSession.insert("college.addCollege", param);
    }

    public void delCollege(IdListVO idListVO) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("collegeList", idListVO.getIdList());
        sqlSession.insert("college.delCollege", param);
    }
}
