package cn.wyu.ServiceImple;

import cn.wyu.Dao.CommentDao;
import cn.wyu.DaoImple.CommentImple;
import cn.wyu.Domain.Comment;
import cn.wyu.Service.CommentService;

public class ComentServiceImple implements CommentService {
    @Override
    public boolean isInsert(Comment comment) {
        CommentDao commentDao = new CommentImple();
        int count = commentDao.insertCom(comment);
        if(count>0) {
            return true;
        }
        else {
            return false;
        }

    }
}
