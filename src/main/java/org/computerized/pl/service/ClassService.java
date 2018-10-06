package org.computerized.pl.service;

import org.computerized.pl.dao.ClassDAO;
import org.computerized.pl.model.classStd.ClassVO;
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

    public ClassVO loadClassById(Integer id) {
        List<ClassVO> classVOList = classDAO.loadClassById(id);

        if(classVOList.size() == 0)
            return null;

        return classVOList.get(0);
    }

    public List<ClassVO> loadClassByYear(Integer year) {
        List<ClassVO> classVOList = classDAO.loadClassByYear(year);
        return classVOList;
    }

    public void addClass(ClassVO classVO) {
        classDAO.addClass(classVO);
    }

    public void modClass(ClassVO classVO) {
        classDAO.modClass(classVO);
    }

    public void removeClass(Integer id) {
        classDAO.removeClass(id);
    }
}
