package cn.wyu.Dao;

import cn.wyu.Domain.Comment;
import cn.wyu.bean.PageInfo;

import java.util.List;

public interface CommentDao {
    /**
     * 插入数据
     * @param comment
     * @return
     */
    int insertCom(Comment comment);
    List<Comment> queryAll();

    PageInfo queryByAll(Integer currentPage);
}
