package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.model.colDept.ColDeptIdVO;
import org.computerized.pl.model.colDept.DeptVO;
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

    public void addDept(String deptName) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("deptName", deptName);
        sqlSession.insert("colDept.addDept", param);
    }

    public void delDept(List<ColDeptIdVO> colDeptIdVOList) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("colDeptIdList", colDeptIdVOList);
        sqlSession.delete("colDept.delDept", param);
    }

    public void mappingColDept(Integer collegeId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("collegeId", collegeId);
        sqlSession.insert("colDept.mappingColDept", param);
    }

    public void removeMappingColDept(List<ColDeptIdVO> colDeptIdVOList) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("colDeptIdList", colDeptIdVOList);
        sqlSession.delete("colDept.removeMappingColDept", param);
    }
}
