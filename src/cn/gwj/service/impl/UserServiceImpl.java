package cn.gwj.service.impl;
/*    
    Created by IntelliJ IDEA.
    Package:cn.gwj.service.impl
    User:1093499975@qq.com
    Date:2019/6/27 0027
    Time:10:30
*/

import cn.gwj.dao.UserDao;
import cn.gwj.dao.impl.UserDaoImpl;
import cn.gwj.entity.User;
import cn.gwj.service.UserService;
import cn.gwj.util.MysqlDatabase;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    MysqlDatabase msql=null;
    private UserDao userDao=null;

    @Override
    public User getUser(User user) {
        msql=new MysqlDatabase();
        userDao=new UserDaoImpl(msql.getConnection());
        try {
            user=userDao.findUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            msql.closeAll();
        }
        return user;
    }

    @Override
    public boolean addUser(User user) {
        msql=new MysqlDatabase();
        userDao=new UserDaoImpl(msql.getConnection());
        boolean flag=false;
        try {
            if(userDao.insertUser(user)>0){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
