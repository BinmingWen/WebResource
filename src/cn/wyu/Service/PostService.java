package cn.wyu.Service;

import cn.wyu.Domain.Posts;
import cn.wyu.bean.PageInfo;

public interface PostService {
    boolean isInsert(Posts post);
    boolean isDelete(int id);

    boolean isUpdate(Posts post);
}
