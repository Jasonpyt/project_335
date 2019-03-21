package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class TransactionManager {
    @Autowired
   private ConnectionUtil connectionUtil;
    //开启事物
    public void beginThreadConnection(){
        try {
            connectionUtil.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //提交事物
    public void  commit(){
        try {
           connectionUtil.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //回滚事物
    public void rollback(){
        try {
            connectionUtil.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //关闭事物
public void release(){
    try {
        connectionUtil.getThreadConnection().setAutoCommit(true);
        connectionUtil.getThreadConnection().close();
        connectionUtil.remove();
    } catch (SQLException e) {
        e.printStackTrace();
    }

}

}
