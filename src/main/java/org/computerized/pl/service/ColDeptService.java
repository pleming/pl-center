package org.computerized.pl.service;

import org.computerized.pl.dao.ColDeptDAO;
import org.computerized.pl.model.DeptVO;
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
}
