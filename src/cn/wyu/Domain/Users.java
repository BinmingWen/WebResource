package cn.wyu.Domain;

public class Users {

    private int userId;
    private int isStu;
    private int isAdmin;
    private String userName;
    private String userNo;
    private String password;
    private String className;

    public Users() {
    }

    public Users(int userId, int isStu, int isAdmin, String userName, String userNo, String password, String className) {
        this.userId = userId;
        this.isStu = isStu;
        this.isAdmin = isAdmin;
        this.userName = userName;
        this.userNo = userNo;
        this.password = password;
        this.className = className;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsStu() {
        return isStu;
    }

    public void setIsStu(int isStu) {
        this.isStu = isStu;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}