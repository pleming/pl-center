package org.computerized.pl.model.counsel;

public class CounselAddVO {
    private Integer classId;
    private Integer counselorUserCode;
    private Integer userCode;
    private String counselContents;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getCounselorUserCode() {
        return counselorUserCode;
    }

    public void setCounselorUserCode(Integer counselorUserCode) {
        this.counselorUserCode = counselorUserCode;
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
