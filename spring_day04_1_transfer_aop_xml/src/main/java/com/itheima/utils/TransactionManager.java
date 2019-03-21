package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Component("txManager")
public class TransactionManager {
    @Autowired
    private ConnectionUtil connectionUtil;
    //开启事务
    public void beginTransaction(){
        try {
            connectionUtil.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //提交事务
    public void commit(){
        try {
            connectionUtil.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //回滚事务
    public void rollback(){
        try {
            connectionUtil.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
