package cn.gwj.service;

import cn.gwj.entity.News;
import cn.gwj.util.Page;

import java.sql.SQLException;
import java.util.List;

/*
    Created by IntelliJ IDEA.
    Package:cn.gwj.service
    User:1093499975@qq.com
    Date:2019/6/27 0027
    Time:09:20
*/
public interface NewsService {
    List<News> getNewsList() throws SQLException;//获取新闻列表
    News getNewsById(int id) throws SQLException;//根据id查询
    boolean updateNews(News news) throws SQLException;//更新数据
//    boolean insertNews(News news) throws SQLException;//添加新闻
    boolean saveNews(News news) throws SQLException;//保存新闻
    boolean delNewsById(int id) throws SQLException;//删除新闻
    List<News> getPageNews(Page page) throws SQLException;//分页服务
    int countNews() throws SQLException;//计算新闻总数

}
