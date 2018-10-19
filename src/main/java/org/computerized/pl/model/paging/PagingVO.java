package org.computerized.pl.model.paging;

public class PagingVO {
    private Integer nowPage;
    private Integer rowPerPage;

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
