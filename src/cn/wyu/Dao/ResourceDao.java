package cn.wyu.Dao;

import cn.wyu.Domain.Resource;
import cn.wyu.bean.PageInfo;

import java.util.List;

public interface ResourceDao {
    /**
     * 插入操作
     * @param Resource
     */
    int insert(Resource resource);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Resource queryById(int id);

    /**
     * 查询所有数据
     * @return
     */
    List<Resource> queryAll();

    /**
     * 根据id删除对应的行
     * @param id
     */
    int deleteById(int id);
    /**
     * 修改数据
     */
    void modify(int id);

    PageInfo queryByAll(Integer currentPage);
    int updateByRe(Resource resource);
}
