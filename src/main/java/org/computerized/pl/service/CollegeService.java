package org.computerized.pl.service;

import org.computerized.pl.dao.CollegeDAO;
import org.computerized.pl.model.CollegeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {
    @Autowired
    private CollegeDAO collegeDAO;

    public List<CollegeVO> loadCollege() {
        return collegeDAO.loadCollege();
    }

}
