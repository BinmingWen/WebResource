package cn.wyu.Dao;

import cn.wyu.Domain.Posts;
import cn.wyu.bean.PageInfo;

import java.util.List;

public interface PostsDao {
    /**
     * 插入操作
     * @param Posts
     */
    int insert(Posts posts);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Posts queryById(int id);

    /**
     * 查询所有数据
     * @return
     */
    List<Posts> queryAll();

    /**
     * 根据id删除对应的行
     * @param id
     */
    int deleteById(int id);
    /**
     * 修改数据
     */
    void modify(int id);
    PageInfo queryByCurPage(Integer currentPage);
    int updatePost(Posts post);

}
