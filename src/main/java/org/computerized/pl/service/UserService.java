package org.computerized.pl.service;

import org.computerized.pl.dao.AuthDAO;
import org.computerized.pl.dao.UserDAO;
import org.computerized.pl.dto.UserAuthDTO;
import org.computerized.pl.dto.UserDTO;
import org.computerized.pl.model.classStd.StdSearchVO;
import org.computerized.pl.model.classStd.StudentVO;
import org.computerized.pl.model.general.AuthVO;
import org.computerized.pl.model.users.PasswdChkVO;
import org.computerized.pl.model.users.UserVO;
import org.computerized.pl.model.users.WorkerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private AuthDAO authDAO;

    public boolean isExistUser(UserDTO userDTO) {
        return userDAO.isExistUser(userDTO.getUserId()).size() == 1 ? true : false;
    }

    public UserAuthDTO signin(UserDTO userDTO) {
        List<UserAuthDTO> userList = userDAO.signin(userDTO.getUserId());

        if (userList.size() == 0)
            return null;

        UserAuthDTO userAuthDTO = userList.get(0);

        if (bCryptPasswordEncoder.matches(userDTO.getPasswd(), userAuthDTO.getPasswd()))
            return userAuthDTO;

        return null;
    }

    public void signup(UserDTO userDTO) {
        userDTO.setPasswd(bCryptPasswordEncoder.encode(userDTO.getPasswd()));
        userDAO.signup(userDTO);
        authDAO.registerAuth();
    }

    public boolean checkPasswd(PasswdChkVO passwdChkVO) {
        PasswdChkVO userInfo = userDAO.checkPasswd(passwdChkVO);

        if (bCryptPasswordEncoder.matches(passwdChkVO.getPasswd(), userInfo.getPasswd()))
            return true;

        return false;
    }

    public UserVO loadUserInfo(Integer userCode) {
        return userDAO.loadUserInfo(userCode);
    }

    public List<WorkerVO> loadWorker() {
        return userDAO.loadWorker();
    }

    public void updateUserInfo(Integer userCode, UserVO userVO) {
        userVO.setPasswd(bCryptPasswordEncoder.encode(userVO.getPasswd()));
        userDAO.updateUserInfo(userCode, userVO);
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
