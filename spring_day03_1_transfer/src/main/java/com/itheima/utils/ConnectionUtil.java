package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class ConnectionUtil {
    //获取数据源
    @Autowired
    private DataSource dataSource;

    //获取线程对象
    private  ThreadLocal<Connection>t1 = new ThreadLocal<Connection>();

    //获取线程中的连接对象
    public  Connection getThreadConnection(){
        Connection conn = t1.get();

        //判断在线程中是否有这个连接对象,如果有就使用,如果没有就去创建
        if (conn == null){
            //从连接池中获取一个
            try {
                Connection connection = dataSource.getConnection();
                t1.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //最终给方法返回一个连接对象即可
        return t1.get();
    }

            //使用完连接对象之后要关闭
            public  void  remove(){
        t1.remove();
            }
}
