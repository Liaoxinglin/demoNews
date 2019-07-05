package cn.gwj.util;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class MysqlDatabase {
    private static final String driver=ConfigManager.getProperties("driver");
    private static final String url=ConfigManager.getProperties("url");
    private static final String user=ConfigManager.getProperties("user");
    private static final String pwd=ConfigManager.getProperties("password");
    private Connection conn=null;

    public MysqlDatabase(){//构造器
        try {
            //加载驱动
            Class.forName(driver);
            //创建数据库连接
            this.conn=DriverManager.getConnection(url,user,pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取数据库连接
     * @return
     */
    public Connection getConnection(){
        return this.conn;
    }
    /**
     * 关闭数据库连接
     */
    public void closeAll(){
        if(this.conn!=null) {
            try {
                this.conn.close();
            } catch (SQLException e) {
                throw  new RuntimeException("关闭连接对象失败");
            }
        }
    }

}

