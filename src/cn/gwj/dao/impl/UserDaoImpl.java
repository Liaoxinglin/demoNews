package cn.gwj.dao.impl;

import cn.gwj.dao.UserDao;
import cn.gwj.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends BaseDao implements UserDao {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public User findUser(User user) throws SQLException {
        String sql="select * from news_users where uname=?";
        ResultSet resultSet= executeQuery(sql,user.getuName());
        if (resultSet.next()){
          user.setId(resultSet.getInt("uid"));
          user.setuName(resultSet.getString("uname"));
          user.setuPwd(resultSet.getString("upwd"));
          user.setRole(resultSet.getInt("role"));
        }
        return user;
        }

    @Override
    public int insertUser(User user) throws SQLException {

        String sql="insert into news_users(uname,upwd) values(?,?)";
        return executeUpdate(sql,user.getuName(),user.getuPwd());

    }
}
