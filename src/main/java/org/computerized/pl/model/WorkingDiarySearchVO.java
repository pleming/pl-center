package org.computerized.pl.model;

public class WorkingDiarySearchVO {
    private String workingDiarySearchStartDate;
    private String workingDiarySearchEndDate;
    private String searchKey;

    public String getWorkingDiarySearchStartDate() {
        return workingDiarySearchStartDate;
    }

    public void setWorkingDiarySearchStartDate(String workingDiarySearchStartDate) {
        this.workingDiarySearchStartDate = workingDiarySearchStartDate;
    }

    public String getWorkingDiarySearchEndDate() {
        return workingDiarySearchEndDate;
    }

    public void setWorkingDiarySearchEndDate(String workingDiarySearchEndDate) {
        this.workingDiarySearchEndDate = workingDiarySearchEndDate;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
