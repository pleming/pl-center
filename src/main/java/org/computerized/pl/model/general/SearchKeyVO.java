package org.computerized.pl.model.general;

import org.computerized.pl.model.paging.PagingVO;

public class SearchKeyVO {
    private String searchKey;
    private PagingVO pagingInfo;

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
