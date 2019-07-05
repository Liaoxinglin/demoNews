package cn.gwj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 执行数据库操作的工具类
 */
public class BaseDao {
    private Connection conn;
    public BaseDao(Connection conn){
        this.conn=conn;
    }

    /**
     * 增、删、改操作
     *
     * @param sql
     *            sql语句
     * @param pm
     *            参数数组
     * @return 执行结果
     * @throws SQLException
     */

    protected int executeUpdate(String sql,Object... pm) throws SQLException{
        int result=0;
        PreparedStatement pstmt=null;
        try {
            pstmt=conn.prepareStatement(sql);
            for (int i=0;i<pm.length;i++){
                pstmt.setObject(i+1,pm[i]);
            }
            System.out.println(pstmt.toString());
            result= pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

/**
 * 查询操作
 *
 * @param sql
 *            sql语句
 * @param pm
 *            参数数组
 * @return 查询结果集
 *      * @throws SQLException
 *      */
    public ResultSet executeQuery(String sql,Object... pm) throws SQLException{
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            System.out.println(sql);
            pstmt= conn.prepareStatement(sql);
            for (int i=0;i<pm.length;i++){
                pstmt.setObject(i+1,pm[i]);
            }
            System.out.println(pstmt);
            rs=pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return rs;
    }
}
