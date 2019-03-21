package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Component
public class ConnectionUtil {
    @Autowired
    private  DataSource dataSource;
    
    private ThreadLocal<Connection> tl = new ThreadLocal<>();
    
    public Connection getThreadConnection(){
        Connection conn = tl.get();
        if(conn == null){
            try {
                //从连接池中获取一个
                Connection connection = dataSource.getConnection();
                //把连接放到线程中
                tl.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tl.get();
    }

    public void remove(){
        tl.remove();
    }
    
}
