package cn.wyu.ServiceImple;

import cn.wyu.Dao.ResourceDao;
import cn.wyu.DaoImple.ResourceImple;
import cn.wyu.Domain.Resource;
import cn.wyu.Service.ResourceService;
import cn.wyu.bean.PageInfo;

public class ResourceServiceImple implements ResourceService {
    @Override
    public boolean isInsert(Resource resource) {
        ResourceDao rescourceDao = new ResourceImple();
        int count = rescourceDao.insert(resource);
        if(count > 0) {
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean isPageinfo(Integer currentPage) {
        ResourceDao resourceDao = new ResourceImple();
        PageInfo pageinfo = resourceDao.queryByAll(currentPage);
        if(pageinfo !=null) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isDelete(int resourceId) {
        ResourceDao resourceDao = new ResourceImple();
        int count = resourceDao.deleteById(resourceId);
        if(count>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isUpdate(Resource resource) {
        ResourceDao resourceDao = new ResourceImple();
        int count = resourceDao.updateByRe(resource);
        if(count>0){
            return true;
        }
        else{
            return false;
        }
    }
}
