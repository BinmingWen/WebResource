package cn.wyu.Domain;

public class Comment {
    private int commentId;
    private String comContent;
    private int com_postId;
    private String comName;

    public Comment(int commentId, String comContent, int com_postId, String comName) {
        this.commentId = commentId;
        this.comContent = comContent;
        this.com_postId = com_postId;
        this.comName = comName;
    }

    public Comment() {
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public int getCom_postId() {
        return com_postId;
    }

    public void setCom_postId(int com_postId) {
        this.com_postId = com_postId;
    }
}
