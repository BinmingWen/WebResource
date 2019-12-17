package cn.wyu.Domain;

//帖子信息表
public class Posts {
    private int postId;
    private String name;
    private String content;
    private String postDate;
    private int isExcellent;
    private int isWorld;

    public Posts() {
    }

    public Posts(int postId, String name, String content, String postDate, int isExcellent, int isWorld) {
        this.postId = postId;
        this.name = name;
        this.content = content;
        this.postDate = postDate;
        this.isExcellent = isExcellent;
        this.isWorld = isWorld;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public int getIsExcellent() {
        return isExcellent;
    }

    public void setIsExcellent(int isExcellent) {
        this.isExcellent = isExcellent;
    }

    public int getIsWorld() {
        return isWorld;
    }

    public void setIsWorld(int isWorld) {
        this.isWorld = isWorld;
    }
}
