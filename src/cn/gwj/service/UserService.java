package cn.gwj.service;
/*    
    Created by IntelliJ IDEA.
    Package:cn.gwj.service
    User:1093499975@qq.com
    Date:2019/6/27 0027
    Time:10:26
*/

import cn.gwj.entity.User;

import java.util.List;

public interface UserService {
    public User getUser(User user);
    public boolean addUser(User user);
}
