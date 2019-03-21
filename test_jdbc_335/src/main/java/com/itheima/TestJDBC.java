package com.itheima;

import com.itheima.domain.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestJDBC {
    /*
     * 测试查询全部
     * */
    @Test
    public void testFindAll() {
        List<User> Userlist = new ArrayList<User>();
        //1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/mybatisdb_335";
        String username = "root";
        String password = "root";
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            //3定义sql语句.获取statement对象
            String sql = "SELECT * FROM user";
            //4.执行sql语句,获取结果集
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getString("sex"));
                Userlist.add(user);
                System.out.println(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ;

                if (stm != null) {
                    try {
                        stm.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}