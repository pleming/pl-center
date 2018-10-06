package org.computerized.pl.service;

import org.computerized.pl.dao.AuthDAO;
import org.computerized.pl.dao.UserDAO;
import org.computerized.pl.dto.UserAuthDTO;
import org.computerized.pl.dto.UserDTO;
import org.computerized.pl.model.general.AuthVO;
import org.computerized.pl.model.classStd.StdSearchVO;
import org.computerized.pl.model.classStd.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private AuthDAO authDAO;

    public boolean isExistUser(UserDTO userDTO) {
        return userDAO.isExistUser(userDTO.getUserId()).size() == 1 ? true : false;
    }

    public UserAuthDTO signin(UserDTO userDTO) {
        List<UserAuthDTO> userList = userDAO.signin(userDTO.getUserId(), userDTO.getPasswd());

        if(userList.size() == 0)
            return null;

        return userList.get(0);
    }

    public void signup(UserDTO userDTO) {
        userDAO.signup(userDTO);
        authDAO.registerAuth();
    }

    public List<StudentVO> loadStudent() {
        return userDAO.loadStudent();
    }

    public List<StudentVO> searchStudent(String searchKey) {
        return userDAO.searchStudent(searchKey);
    }

    public List<StdSearchVO> loadStudentByCondition(Map<String, Object> param) {
        return userDAO.loadStudentByCondition(param);
    }

    public List<StdSearchVO> loadStudentForAdmin(Map<String, Object> param) {
        return userDAO.loadStudentForAdmin(param);
    }

    public void updateAuth(AuthVO authVO) {
        authDAO.updateAuth(authVO);
    }
}
