package org.computerized.pl.model;

public class ResponseVO {
    private Boolean status;
    private Integer code;
    private Object contents;

    public ResponseVO() {
    }

    public ResponseVO(Boolean status, Integer code, Object contents) {
        this.status = status;
        this.code = code;
        this.contents = contents;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getContents() {
        return contents;
    }

    public void setContents(Object contents) {
        this.contents = contents;
    }
}
