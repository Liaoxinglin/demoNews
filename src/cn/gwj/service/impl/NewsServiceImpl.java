package cn.gwj.service.impl;

import cn.gwj.dao.NewsDao;
import cn.gwj.dao.impl.NewsDaoImpl;
import cn.gwj.entity.News;
import cn.gwj.service.NewsService;
import cn.gwj.util.MysqlDatabase;
import cn.gwj.util.Page;

import java.sql.SQLException;
import java.util.List;

/*
    Created by IntelliJ IDEA.
    Package:cn.gwj.service.impl
    User:1093499975@qq.com
    Date:2019/6/27 0027
    Time:09:27
*/
public class NewsServiceImpl implements NewsService {

    private MysqlDatabase msql=null;
    private NewsDao newsDao=null;


    @Override
    public List<News> getNewsList() throws SQLException{
        msql=new MysqlDatabase();
        newsDao=new NewsDaoImpl(msql.getConnection());
        try{
            return newsDao.findNews();
        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }finally {
            msql.closeAll();//把连接对象关闭后，后两个也不存在了
        }
    }

    @Override
    public News getNewsById(int id) throws SQLException{
        msql=new MysqlDatabase();
        newsDao=new NewsDaoImpl(msql.getConnection());
        try{
            return newsDao.findById(id);
        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }finally {
            msql.closeAll();
        }
    }

    @Override
    public boolean updateNews(News news) throws SQLException{
        msql=new MysqlDatabase();
        newsDao=new NewsDaoImpl(msql.getConnection());
        boolean flag=false;
        try{
            if(newsDao.updateNews(news)>0){
                flag=true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }finally {
            msql.closeAll();
        }
        return flag;
    }

    @Override
    public boolean saveNews(News news) {
        msql=new MysqlDatabase();
        newsDao=new NewsDaoImpl(msql.getConnection());
        try {
            return newsDao.insertNews(news)>0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("保存新闻失败");
        }
    }

    @Override
    public boolean delNewsById(int id) throws SQLException {
        msql=new MysqlDatabase();
        newsDao=new NewsDaoImpl(msql.getConnection());
        try {
            return newsDao.delNewsById(id)>0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw  e;
        }
    }

    @Override
    public List<News> getPageNews(Page page) throws SQLException {
        msql=new MysqlDatabase();
        newsDao=new NewsDaoImpl(msql.getConnection());
        try {
//            return new NewsDaoImpl(msql.getConnection()).findPageNews(page);
            return newsDao.findPageNews(page);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  e;
        }finally {
            msql.closeAll();
        }
    }

    @Override
    public int countNews() throws SQLException {
        msql=new MysqlDatabase();
        newsDao=new NewsDaoImpl(msql.getConnection());
        try {
            return newsDao.countNews();
        } catch (SQLException e) {
            e.printStackTrace();
            throw  e;
        }finally {
            msql.closeAll();
        }
    }
}
