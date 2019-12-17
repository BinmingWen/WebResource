package cn.wyu.ServiceImple;

import cn.wyu.Controller.Admin.Post.PostsServlet;
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

    @Override
    public boolean isDelete(int id) {
        PostsDao postsDao = new PostsImple();
        int count = postsDao.deleteById(id);
        if(count>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isUpdate(Posts post) {
         PostsDao postsDao = new PostsImple();
         int count = postsDao.updatePost(post);
         if(count>0){
             return true;
         }
        return false;
    }
}
