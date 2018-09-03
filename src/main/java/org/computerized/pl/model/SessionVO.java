package org.computerized.pl.model;

import org.computerized.pl.dto.UserAuthDTO;

import java.io.Serializable;

public class SessionVO implements Serializable {
    private Integer userCode;
    private String userId;
    private String studentCode;
    private Integer colId;
    private Integer deptId;
    private String name;
    private String email;
    private String phone;
    private Integer auth;

    public Integer getUserCode() {
        return userCode;
    }

    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public Integer getColId() {
        return colId;
    }

    public void setColId(Integer colId) {
        this.colId = colId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }

    public static SessionVO parseSessionVO(UserAuthDTO userAuthDTO) {
        SessionVO sessionVO = new SessionVO();

        sessionVO.setColId(userAuthDTO.getColId());
        sessionVO.setDeptId(userAuthDTO.getDeptId());
        sessionVO.setEmail(userAuthDTO.getEmail());
        sessionVO.setName(userAuthDTO.getName());
        sessionVO.setPhone(userAuthDTO.getPhone());
        sessionVO.setStudentCode(userAuthDTO.getStudentCode());
        sessionVO.setUserCode(userAuthDTO.getUserCode());
        sessionVO.setUserId(userAuthDTO.getUserId());
        sessionVO.setAuth(userAuthDTO.getAuth());

        return sessionVO;
    }
}
