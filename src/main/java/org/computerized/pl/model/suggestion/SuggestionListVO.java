package org.computerized.pl.model.suggestion;

import java.util.Date;

public class SuggestionListVO {
    private Integer id;
    private String title;
    private String writer;
    private Date writeDatetime;
    private Integer views;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getWriteDatetime() {
        return writeDatetime;
    }

    public void setWriteDatetime(Date writeDatetime) {
        this.writeDatetime = writeDatetime;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}
