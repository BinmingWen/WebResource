package cn.wyu.bean;

import java.util.List;
import java.util.Map;

public class PageInfo {

    private List<?> list;     //分页对象集合
    private Integer currentPage;  //当前页
    private Integer beginPage;    //开始页数
    private Integer endPage;      //结束页数
    private Integer totalPages;   //总页数
    private Long totalRecords; //总记录数

    public PageInfo(List<?> list, Integer currentPage, Long totalRecords) {
        this.list = list;
        this.currentPage = currentPage;
        this.totalRecords = totalRecords;
        //初始化总页数，开始、结束、页数
        if(this.totalRecords%5==0) {
            this.totalPages = this.totalRecords.intValue()/5;
        }else{
            this.totalPages = (this.totalRecords.intValue()/5+1);
        }
        if(totalPages<6) {
            this.beginPage = 1;
            this.endPage = this.currentPage;
        }else{
            this.beginPage = this.currentPage-3;
            this.endPage = this.currentPage+2;
            if(this.beginPage <1){
                this.beginPage = 1;
                this.endPage = 6;
            }
            else if(this.endPage>this.totalPages){
                this.beginPage =this.totalPages-6;
                this.endPage = this.totalPages;
            }
        }
    }

    public PageInfo() {
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(Integer beginPage) {
        this.beginPage = beginPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }
}
