package org.computerized.pl.dto;

import org.computerized.pl.model.general.UserVO;

public class UserDTO {
    private String userId;
    private String passwd;
    private String studentCode;
    private Integer colId;
    private Integer deptId;
    private String name;
    private String email;
    private String phone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
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

    public static UserDTO parseUserDTO(UserVO userVO) {
        UserDTO userDTO = new UserDTO();

        userDTO.setColId(userVO.getColId());
        userDTO.setDeptId(userVO.getDeptId());
        userDTO.setEmail(userVO.getEmail());
        userDTO.setName(userVO.getName());
        userDTO.setPasswd(userVO.getPasswd());
        userDTO.setPhone(userVO.getPhone());
        userDTO.setStudentCode(userVO.getStudentCode());
        userDTO.setUserId(userVO.getUserId());

        return userDTO;
    }
}
