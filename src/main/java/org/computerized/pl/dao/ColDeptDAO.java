package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.model.DeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ColDeptDAO {
    @Autowired
    private SqlSession sqlSession;

    public List<DeptVO> loadDeptListByColId(Integer colId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("colId", colId);
        return sqlSession.selectList("colDept.loadDeptListByColId", param);
    }
}
