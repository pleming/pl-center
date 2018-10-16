package org.computerized.pl.model.counsel;

public class CounselAddForAdminVO {
    private Integer counselorUserCode;
    private Integer classId;
    private Integer userCode;
    private String counselDatetime;
    private String counselContents;

    public Integer getCounselorUserCode() {
        return counselorUserCode;
    }

    public void setCounselorUserCode(Integer counselorUserCode) {
        this.counselorUserCode = counselorUserCode;
    }

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

    public String getCounselDatetime() {
        return counselDatetime;
    }

    public void setCounselDatetime(String counselDatetime) {
        this.counselDatetime = counselDatetime;
    }

    public String getCounselContents() {
        return counselContents;
    }

    public void setCounselContents(String counselContents) {
        this.counselContents = counselContents;
    }
}
