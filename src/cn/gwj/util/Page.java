package cn.gwj.util;
/*    
    Created by IntelliJ IDEA.
    Package:cn.gwj.util
    User:1093499975@qq.com
    Date:2019/7/1 0001
    Time:12:41
*/

import cn.gwj.entity.News;

import java.util.List;

public class Page {
    private int currPageNo=1;//当前页码
    private int pageSize=5;//页面大小，即每页显示记录数
    private int totalCount;//记录总数
    private int totalPageCount=0;//总页数
    private List<News> newsList;//每页新闻集合

    public int getCurrPageNo() {
        if (totalPageCount == 0)
            return 0;
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        if (currPageNo > 0)
            this.currPageNo = currPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 0)
            this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if(totalCount>0){
            this.totalCount = totalCount;
            // 计算总页数
            totalPageCount = this.totalCount % pageSize == 0 ? (this.totalCount / pageSize)
                    : (this.totalCount / pageSize + 1);
        }
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }


}
