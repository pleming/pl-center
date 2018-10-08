package org.computerized.pl.model.suggestion;

import java.util.Date;

public class SuggestionVO {
    private Integer id;
    private String title;
    private String contents;
    private Integer writerUserCode;
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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Integer getWriterUserCode() {
        return writerUserCode;
    }

    public void setWriterUserCode(Integer writerUserCode) {
        this.writerUserCode = writerUserCode;
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
