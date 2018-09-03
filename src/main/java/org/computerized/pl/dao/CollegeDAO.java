package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.model.CollegeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CollegeDAO {
    @Autowired
    private SqlSession sqlSession;

    public List<CollegeVO> loadCollege() {
        return sqlSession.selectList("college.loadCollege");
    }
}
