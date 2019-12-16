package cn.wyu.ServiceImple;

import cn.wyu.Dao.PostsDao;
import cn.wyu.DaoImple.PostsImple;
import cn.wyu.Domain.Posts;
import cn.wyu.Service.PostService;

public class PostServiceImple implements PostService {
    @Override
    public boolean isInsert(Posts post) {
        PostsDao postsDao = new PostsImple();
        int count = postsDao.insert(post);
        if(count>0) {
            return true;

        }
        else {
            return false;
        }
    }
}
