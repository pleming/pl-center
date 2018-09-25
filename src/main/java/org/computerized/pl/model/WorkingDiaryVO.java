package org.computerized.pl.model;

import java.util.Date;

public class WorkingDiaryVO {
    private Integer workingDiaryId;
    private Integer userCode;
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

    public Integer getUserCode() {
        return userCode;
    }

    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
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
