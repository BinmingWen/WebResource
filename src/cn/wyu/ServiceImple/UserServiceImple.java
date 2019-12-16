package cn.wyu.ServiceImple;

import cn.wyu.Dao.UsersDao;
import cn.wyu.DaoImple.UsersImple;
import cn.wyu.Domain.Users;
import cn.wyu.Service.UserService;
import cn.wyu.bean.PageInfo;

public class UserServiceImple implements UserService {
    @Override
    public boolean login(Users user) {
        UsersDao usersDao = new UsersImple();
        Users dbuser = usersDao.queryByUser(user.getUserName(),user.getPassword());
        if(dbuser.getPassword().equals(user.getPassword()) && dbuser.getUserName().equals(user.getUserName())) {
            user.setClassName(dbuser.getClassName());
            user.setUserId(dbuser.getUserId());
            user.setIsStu(dbuser.getIsStu());
            user.setIsAdmin(dbuser.getIsAdmin());
            user.setUserNo(dbuser.getUserNo());
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean add(Users user) {
        UsersDao usersDao = new UsersImple();
        if(!(usersDao.isExist(user.getUserNo()))) {
            return usersDao.addUsers(user.getUserName(), user.getUserNo(), user.getPassword(), user.getClassName(), user.getIsStu());
        }
        return false;
    }

    @Override
    public boolean userList(int currentPage) {
        UsersDao usersDao = new UsersImple();
        PageInfo pageInfo = usersDao.queryByCurrent(currentPage);
        if(pageInfo == null){
            return false;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean userDelete(int id) {
        UsersDao usersDao = new UsersImple();
        int effectCount = usersDao.deleteById(id);
        if(effectCount > 0) {
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public boolean userEdit(Users user) {
        UsersDao usersDao = new UsersImple();
        int count = usersDao.updateUser(user.getUserId(),user.getIsStu(),user.getUserName(),user.getUserNo(),user.getPassword(),user.getClassName());
        if(count>0) {
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public boolean userUpdate(String no, String name, String classname,int id) {
        UsersDao usersDao = new UsersImple();

        return ((UsersImple) usersDao).updateUser(no,name,classname,id);
    }

    @Override
    public boolean updatePassword(Users user) {
        UsersDao usersDao = new UsersImple();
        int count = usersDao.updateUserByUser(user.getUserId(),user.getPassword());
        if(count>0) {
            return true;
        }
        else {
            return false;
        }
    }
}
