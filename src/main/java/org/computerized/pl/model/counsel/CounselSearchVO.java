package org.computerized.pl.model.counsel;

import org.computerized.pl.model.paging.PagingVO;

public class CounselSearchVO {
    private Integer year;
    private Integer semester;
    private Integer classNo;
    private String searchKey;
    private PagingVO pagingInfo;

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
