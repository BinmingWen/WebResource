package cn.wyu.Service;

import cn.wyu.Domain.Students;
import cn.wyu.Domain.Users;

public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean login(Users user);

    /**
     * 添加数据
     * @param user
     * @return
     */
    boolean add(Users user);

    /**
     * 用户分页列表
     * @param currentPage
     * @return
     */
    boolean userList(int currentPage);

    /**
     * 根据id删除用户记录
     * @param id
     * @return
     */
    boolean userDelete(int id);
    boolean userEdit(Users user);
}
