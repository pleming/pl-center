package org.computerized.pl.service;

import org.computerized.pl.dao.ClassDAO;
import org.computerized.pl.model.ClassVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassDAO classDAO;

    public List<ClassVO> loadClass() {
        return classDAO.loadClass();
    }

    public void addClass(ClassVO classVO) {
        classDAO.addClass(classVO);
    }
}
