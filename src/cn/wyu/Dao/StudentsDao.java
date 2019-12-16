package cn.wyu.Dao;

import cn.wyu.Domain.Students;

import java.util.List;

public interface StudentsDao {
    /**
     * 插入操作
     * @param Resource
     */
    void insert(Students students);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Students queryByStu(String userName,String password);

    /**
     * 查询所有数据
     * @return
     */
    List<Students> queryAll();

    /**
     * 根据id删除对应的行
     * @param id
     */
    void deleteById(int id);
    /**
     * 修改数据
     */
    void modify(int id);
}
