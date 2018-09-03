package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.dto.UserAuthDTO;
import org.computerized.pl.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDAO {
    @Autowired
    private SqlSession sqlSession;

    public List<UserDTO> isExistUser(String userId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        return sqlSession.selectList("users.isExistUser", param);
    }

    public List<UserAuthDTO> signin(String userId, String passwd) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("userId", userId);
        param.put("passwd", passwd);

        return sqlSession.selectList("users.signin", param);
    }

    public void signup(UserDTO userDTO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("userId", userDTO.getUserId());
        param.put("passwd", userDTO.getPasswd());
        param.put("colId", userDTO.getColId());
        param.put("deptId", userDTO.getDeptId());
        param.put("studentCode", userDTO.getStudentCode());
        param.put("name", userDTO.getName());
        param.put("email", userDTO.getEmail());
        param.put("phone", userDTO.getPhone());

        sqlSession.insert("users.signup", param);
    }
}
