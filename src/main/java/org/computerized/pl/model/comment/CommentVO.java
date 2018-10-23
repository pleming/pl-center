package org.computerized.pl.model.comment;

public class CommentVO {
    private Integer id;
    private Integer postId;
    private Integer parentCommentId;
    private String contents;
    private Integer writerId;
    private String writer;
    private String writeDatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Integer getWriterId() {
        return writerId;
    }

    public void setWriterId(Integer writerId) {
        this.writerId = writerId;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getWriteDatetime() {
        return writeDatetime;
    }

    public void setWriteDatetime(String writeDatetime) {
        this.writeDatetime = writeDatetime;
    }
}
