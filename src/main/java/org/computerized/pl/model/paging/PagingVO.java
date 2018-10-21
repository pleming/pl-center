package org.computerized.pl.model.paging;

public class PagingVO {
    private Integer nowPage;
    private Integer rowPerPage;

    public PagingVO() {
        super();
    }

    public PagingVO(Integer nowPage, Integer rowPerPage) {
        this.nowPage = nowPage;
        this.rowPerPage = rowPerPage;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getRowPerPage() {
        return rowPerPage;
    }

    public void setRowPerPage(Integer rowPerPage) {
        this.rowPerPage = rowPerPage;
    }
}
