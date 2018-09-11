package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.model.ClassVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ClassDAO {
    @Autowired
    private SqlSession sqlSession;

    public List<ClassVO> loadClass() {
        return sqlSession.selectList("class.loadClass");
    }

    public List<ClassVO> loadClassById(Integer id) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        return sqlSession.selectList("class.loadClassById", param);
    }

    public void addClass(ClassVO classVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("year", classVO.getYear());
        param.put("semester", classVO.getSemester());
        param.put("classNo", classVO.getClassNo());

        sqlSession.insert("class.addClass", param);
    }

    public void modClass(ClassVO classVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("id", classVO.getId());
        param.put("year", classVO.getYear());
        param.put("semester", classVO.getSemester());
        param.put("classNo", classVO.getClassNo());

        sqlSession.update("class.modClass", param);
    }
}
