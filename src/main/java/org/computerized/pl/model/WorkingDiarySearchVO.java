package org.computerized.pl.model;

import java.util.Date;

public class WorkingDiarySearchVO {
    private Date workingDiarySearchStartDate;
    private Date workingDiarySearchEndDate;
    private String searchKey;

    public Date getWorkingDiarySearchStartDate() {
        return workingDiarySearchStartDate;
    }

    public void setWorkingDiarySearchStartDate(Date workingDiarySearchStartDate) {
        this.workingDiarySearchStartDate = workingDiarySearchStartDate;
    }

    public Date getWorkingDiarySearchEndDate() {
        return workingDiarySearchEndDate;
    }

    public void setWorkingDiarySearchEndDate(Date workingDiarySearchEndDate) {
        this.workingDiarySearchEndDate = workingDiarySearchEndDate;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
