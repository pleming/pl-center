package org.computerized.pl.model.workingDiary;

import org.computerized.pl.model.paging.PagingVO;

public class WorkingDiarySearchVO {
    private String workingDiarySearchStartDate;
    private String workingDiarySearchEndDate;
    private String searchKey;
    private PagingVO pagingInfo;

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

    public PagingVO getPagingInfo() {
        return pagingInfo;
    }

    public void setPagingInfo(PagingVO pagingInfo) {
        this.pagingInfo = pagingInfo;
    }
}
