package org.computerized.pl.service;

import org.computerized.pl.dao.ColDeptDAO;
import org.computerized.pl.model.colDept.ColDeptIdVO;
import org.computerized.pl.model.colDept.DeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColDeptService {
    @Autowired
    private ColDeptDAO colDeptDAO;

    public List<DeptVO> loadDeptListByColId(Integer colId) {
        return colDeptDAO.loadDeptListByColId(colId);
    }

    public void addDept(String deptName) {
        colDeptDAO.addDept(deptName);
    }

    public void delDept(List<ColDeptIdVO> colDeptIdVOList) {
        colDeptDAO.delDept(colDeptIdVOList);
    }

    public void mappingColDept(Integer collegeId) {
        colDeptDAO.mappingColDept(collegeId);
    }

    public void removeMappingColDept(List<ColDeptIdVO> colDeptIdVOList) {
        colDeptDAO.removeMappingColDept(colDeptIdVOList);
    }
}
