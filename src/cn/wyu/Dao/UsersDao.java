package cn.wyu.Dao;

import cn.wyu.Domain.Users;
import cn.wyu.bean.PageInfo;

public interface UsersDao {
    /**
     * 查询用户，进行登陆
     * @param userName
     * @param password
     * @return
     */
    Users queryByUser(String userName,String password);
    boolean isExist(String No);
    //PageInfo queryAll();
    PageInfo queryByCurrent(int currentPage);

    boolean addUsers(String name, String no, String pwd, String classname, int isStu);

    int deleteById(int id);
    Users queryById(int id);
    int updateUser(int userId,int isStu,String userName,String userNo,String password,String className);
}
