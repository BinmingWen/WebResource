package cn.wyu.Service;

import cn.wyu.Domain.Resource;

public interface ResourceService {
    /**
     * 插入数据
     * @param resource
     * @return
     */
    boolean isInsert(Resource resource);
    boolean isPageinfo(Integer currentPage);
}
