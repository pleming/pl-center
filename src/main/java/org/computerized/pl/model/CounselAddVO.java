package org.computerized.pl.model;

public class CounselAddVO {
    private Integer classId;
    private Integer userCode;
    private String counselContents;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getUserCode() {
        return userCode;
    }

    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
    }

    public String getCounselContents() {
        return counselContents;
    }

    public void setCounselContents(String counselContents) {
        this.counselContents = counselContents;
    }
}
