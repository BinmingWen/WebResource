package cn.wyu.Dao;

import cn.wyu.Domain.Category;

import java.util.List;

public interface CategoryDao {
    /**
     * 插入操作
     * @param category
     */
    void insert(Category category);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Category queryById(int id);

    /**
     * 查询所有数据
     * @return
     */
    List<Category> queryAll();

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
