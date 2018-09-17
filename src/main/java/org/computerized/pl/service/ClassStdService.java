package org.computerized.pl.service;

import org.computerized.pl.dao.ClassStdDAO;
import org.computerized.pl.model.ClassStdListlVO;
import org.computerized.pl.model.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassStdService {
    @Autowired
    private ClassStdDAO classStdDAO;

    public List<StudentVO> loadStudentInClass(Integer classId) {
        return classStdDAO.loadStudentInClass(classId);
    }

    public void addStudentInClass(ClassStdListlVO classStdListlVO) {
        classStdDAO.addStudentInClass(classStdListlVO);
    }

    public void delStudentInClass(ClassStdListlVO classStdListlVO) {
        classStdDAO.delStudentInClass(classStdListlVO);
    }
}
