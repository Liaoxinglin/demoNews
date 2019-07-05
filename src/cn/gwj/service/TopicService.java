package cn.gwj.service;
/*    
    Created by IntelliJ IDEA.
    Package:cn.gwj.service
    User:1093499975@qq.com
    Date:2019/6/27 0027
    Time:09:51
*/

import cn.gwj.entity.Topic;

import java.sql.SQLException;
import java.util.List;

public interface TopicService {
    List<Topic> getTopicList() throws SQLException;//获取所有新闻主题
    boolean saveTopic(Topic topic);//保存主题
}
