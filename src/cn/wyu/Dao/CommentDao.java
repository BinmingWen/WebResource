package cn.wyu.Dao;

import cn.wyu.Domain.Comment;

import java.util.List;

public interface CommentDao {
    /**
     * 插入数据
     * @param comment
     * @return
     */
    int insertCom(Comment comment);
    List<Comment> queryAll();
}
