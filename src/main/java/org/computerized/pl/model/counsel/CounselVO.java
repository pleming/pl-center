package org.computerized.pl.model.counsel;

import java.util.Date;

public class CounselVO {
    private Integer counselId;
    private String userId;
    private String college;
    private String dept;
    private String studentCode;
    private Integer year;
    private Integer semester;
    private Integer classNo;
    private String name;
    private Date counselDatetime;
    String counselContents;
    String counselorName;

    public Integer getCounselId() {
        return counselId;
    }

    public void setCounselId(Integer counselId) {
        this.counselId = counselId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCounselDatetime() {
        return counselDatetime;
    }

    public void setCounselDatetime(Date counselDatetime) {
        this.counselDatetime = counselDatetime;
    }

    public String getCounselContents() {
        return counselContents;
    }

    public void setCounselContents(String counselContents) {
        this.counselContents = counselContents;
    }

    public String getCounselorName() {
        return counselorName;
    }

    public void setCounselorName(String counselorName) {
        this.counselorName = counselorName;
    }
}
