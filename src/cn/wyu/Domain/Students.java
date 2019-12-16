package cn.wyu.Domain;

//学生信息表
public class Students {
    private int studentId;
    private String name;
    private String password;
    private int className;
    private int majorOrEle;
    private String teacher;
    private String selfDescn;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getClassName() {
        return className;
    }

    public void setClassName(int className) {
        this.className = className;
    }

    public int getMajorOrEle() {
        return majorOrEle;
    }

    public void setMajorOrEle(int majorOrEle) {
        this.majorOrEle = majorOrEle;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSelfDescn() {
        return selfDescn;
    }

    public void setSelfDescn(String selfDescn) {
        this.selfDescn = selfDescn;
    }
}
