package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.model.ClassStdListlVO;
import org.computerized.pl.model.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ClassStdDAO {
    @Autowired
    private SqlSession sqlSession;

    public List<StudentVO> loadStudentInClass(Integer classId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("classId", classId);
        return sqlSession.selectList("classStd.loadStudentInClass", param);
    }

    public void addStudentInClass(ClassStdListlVO classStdListlVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("classId", classStdListlVO.getClassId());
        param.put("userList", classStdListlVO.getUserList());

        sqlSession.insert("classStd.addStudentInClass", param);
    }

    public void delStudentInClass(ClassStdListlVO classStdListlVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("classId", classStdListlVO.getClassId());
        param.put("userList", classStdListlVO.getUserList());

        sqlSession.delete("classStd.delStudentInClass", param);
    }
}
