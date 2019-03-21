package com.itheima.dao;

import com.itheima.domain.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class BookDao {
    //jdbc查询全部
    public List<Book> findAll(){
        List<Book> bookList = new ArrayList<>();

        //1. 注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/lucene_335";
        String username = "root";
        String password = "root";
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            //2. 获取连接
            conn = DriverManager.getConnection(url, username, password);
            //3. 创建Statement对象
            String sql = "select * from book";
            stm = conn.createStatement();
            //4. 执行sql语句获取结果集
            rs = stm.executeQuery(sql);
            //5. 处理结果集
            while(rs.next()){
                //如果存在记录，就说明存在一个对象
                Book book = new Book();
                //给book赋值
                int id = rs.getInt("id");
                book.setId(id);
                book.setName(rs.getString("name"));
                book.setPrice(rs.getDouble("price"));
                book.setPic(rs.getString("pic"));
                book.setDescription(rs.getString("description"));
                //把book添加到集合中
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6. 释放资源
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //6. 释放资源
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //6. 释放资源
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return bookList;
    }
}
