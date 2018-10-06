package org.computerized.pl.model.workingDiary;

import java.util.Date;

public class WorkingDiaryForAdminVO {
    private Integer workingDiaryId;
    private String userId;
    private String college;
    private String dept;
    private String studentCode;
    private String name;
    private Date workingStartDatetime;
    private Date workingEndDatetime;
    private String workingContents;

    public Integer getWorkingDiaryId() {
        return workingDiaryId;
    }

    public void setWorkingDiaryId(Integer workingDiaryId) {
        this.workingDiaryId = workingDiaryId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getWorkingStartDatetime() {
        return workingStartDatetime;
    }

    public void setWorkingStartDatetime(Date workingStartDatetime) {
        this.workingStartDatetime = workingStartDatetime;
    }

    public Date getWorkingEndDatetime() {
        return workingEndDatetime;
    }

    public void setWorkingEndDatetime(Date workingEndDatetime) {
        this.workingEndDatetime = workingEndDatetime;
    }

    public String getWorkingContents() {
        return workingContents;
    }

    public void setWorkingContents(String workingContents) {
        this.workingContents = workingContents;
    }
}
