package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.code.CodeDefinition;
import org.computerized.pl.dto.UserAuthDTO;
import org.computerized.pl.dto.UserDTO;
import org.computerized.pl.model.classStd.StdSearchVO;
import org.computerized.pl.model.classStd.StudentVO;
import org.computerized.pl.model.paging.PagingVO;
import org.computerized.pl.model.users.PasswdChkVO;
import org.computerized.pl.model.users.UserVO;
import org.computerized.pl.model.users.WorkerVO;
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

    public List<UserAuthDTO> signin(String userId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
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

    public PasswdChkVO checkPasswd(PasswdChkVO passwdChkVO) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userCode", passwdChkVO.getUserCode());

        List<PasswdChkVO> list = sqlSession.selectList("users.checkPasswd", param);
        return list.get(0);
    }

    public UserVO loadUserInfo(Integer userCode) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userCode", userCode);

        List<UserVO> list = sqlSession.selectList("users.loadUserInfo", param);
        return list.get(0);
    }

    public List<WorkerVO> loadWorker() {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("auth", CodeDefinition.Auth.WORKER.getCode());
        return sqlSession.selectList("users.loadWorker", param);
    }

    public void updateUserInfo(Integer userCode, UserVO userVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("userCode", userCode);
        param.put("passwd", userVO.getPasswd());
        param.put("colId", userVO.getColId());
        param.put("deptId", userVO.getDeptId());
        param.put("studentCode", userVO.getStudentCode());
        param.put("name", userVO.getName());
        param.put("email", userVO.getEmail());
        param.put("phone", userVO.getPhone());

        sqlSession.update("users.updateUserInfo", param);

    }

    public List<StudentVO> loadStudent(PagingVO pagingVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("startIdx", (pagingVO.getNowPage() - 1) * pagingVO.getRowPerPage());
        param.put("rowBound", pagingVO.getRowPerPage());

        return sqlSession.selectList("users.loadStudent", param);
    }

    public Integer getTotalRowCount() {
        List<Integer> list = sqlSession.selectList("users.getTotalRowCount");
        return list.get(0);
    }

    public List<StudentVO> searchStudent(String searchKey, PagingVO pagingVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("startIdx", (pagingVO.getNowPage() - 1) * pagingVO.getRowPerPage());
        param.put("rowBound", pagingVO.getRowPerPage());
        param.put("searchKey", "%" + searchKey + "%");

        return sqlSession.selectList("users.loadStudent", param);
    }

    public Integer getTotalRowCountForSearch(String searchKey) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("searchKey", "%" + searchKey + "%");

        List<Integer> list = sqlSession.selectList("users.getTotalRowCountForSearch", param);
        return list.get(0);
    }

    public List<StdSearchVO> loadStudentByCondition(Map<String, Object> param) {
        Map<String, Object> dbParam = new HashMap<String, Object>();

        dbParam.put("requireClassInfo", (boolean) param.get("requireClassInfo"));
        dbParam.put("auth", CodeDefinition.Auth.STUDENT.getCode());
        dbParam.put("searchKey", "%" + param.get("searchKey").toString() + "%");

        return sqlSession.selectList("users.loadStudentByCondition", dbParam);
    }

    public List<StdSearchVO> loadWorkerForWorkingDiary(Map<String, Object> param) {
        Map<String, Object> dbParam = new HashMap<String, Object>();

        dbParam.put("requireClassInfo", (boolean) param.get("requireClassInfo"));
        dbParam.put("auth", CodeDefinition.Auth.WORKER.getCode());
        dbParam.put("searchKey", "%" + param.get("searchKey").toString() + "%");

        return sqlSession.selectList("users.loadStudentByCondition", dbParam);
    }
}
