package org.computerized.pl.dto;

public class UserAuthDTO extends UserDTO {
    private Integer userCode;
    private Integer auth;

    public Integer getUserCode() {
        return userCode;
    }

    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
    }

    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }
}
