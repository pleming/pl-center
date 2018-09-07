package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.model.AuthVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthDAO {
    @Autowired
    private SqlSession sqlSession;

    public void registerAuth() {
        sqlSession.insert("auth.registerAuth");
    }

    public void updateAuth(AuthVO authVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("userCode", authVO.getUserCode());
        param.put("auth", authVO.getAuth());

        sqlSession.update("auth.updateAuth", param);
    }
}
