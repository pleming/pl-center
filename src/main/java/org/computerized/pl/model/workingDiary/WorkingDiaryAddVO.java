package org.computerized.pl.model.workingDiary;

import java.util.Date;

public class WorkingDiaryAddVO {
    private Integer userCode;
    private Date workingStartDatetime;
    private Date workingEndDatetime;
    private String workingContents;

    public Integer getUserCode() {
        return userCode;
    }

    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
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
