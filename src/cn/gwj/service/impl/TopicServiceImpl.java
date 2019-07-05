package cn.gwj.service.impl;
/*    
    Created by IntelliJ IDEA.
    Package:cn.gwj.service.impl
    User:1093499975@qq.com
    Date:2019/6/27 0027
    Time:09:54
*/

import cn.gwj.dao.TopicDao;
import cn.gwj.dao.impl.TopicDaoImpl;
import cn.gwj.entity.Topic;
import cn.gwj.service.TopicService;
import cn.gwj.util.MysqlDatabase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TopicServiceImpl implements TopicService {
    private MysqlDatabase msql=null;
    private TopicDao topicDao=null;

    @Override
    public List<Topic> getTopicList() throws SQLException {
        msql=new MysqlDatabase();
        topicDao=new TopicDaoImpl(msql.getConnection());
        try{
            return topicDao.findAll();
        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }finally {
            msql.closeAll();//把连接对象关闭后，后两个也不存在了
        }
    }

    @Override
    public boolean saveTopic(Topic topic) {
        msql=new MysqlDatabase();
        topicDao=new TopicDaoImpl(msql.getConnection());
        boolean flag=false;
        try {
            flag = topicDao.add(topic)>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            msql.closeAll();
        }
        return flag;
    }
}
