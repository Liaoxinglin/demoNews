package cn.gwj.dao;

import cn.gwj.entity.News;
import cn.gwj.util.Page;

import java.sql.SQLException;
import java.util.List;

public interface NewsDao {
    List<News> findNews() throws SQLException;//查询新闻列表
    News findById(int id) throws SQLException; //根据id查询
    int updateNews(News news) throws SQLException; //根据id修改
    int insertNews(News news) throws SQLException;//添加新闻
    int delNewsById(int id)throws SQLException;//删除新闻
    List<News> findPageNews(Page page) throws  SQLException;//分页
    int countNews() throws SQLException;//计算总页数
}
