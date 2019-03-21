package frame.utils;

import frame.domain.Configuration;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 工具类：用来执行具体的操作
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class Executor {

    private Configuration cfg;

    public Executor(Configuration cfg) {
        this.cfg = cfg;
    }

    private Connection conn;
    private Statement stm;
    private ResultSet rs;

    /**
     * 执行查询操作，返回list集合
     *
     * 执行sql
     * @return
     */
    public List executeQuery(String sql ,String resultType){
        //创建集合对象
        List list = new ArrayList();
        //1.注册驱动
        try {
            Class.forName(cfg.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //2. 获取连接对象
            conn = DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
            //3. 创建statement对象
            stm = conn.createStatement();
            //4. 执行sql语句，返回结果集
            rs = stm.executeQuery(sql);
            //5. 处理结果集:不考虑对象和数据表
            //通过反射创建具体的对象
            //获取字节码
            Class clazz = Class.forName(resultType);
            //通过反射获取所有的方法
            Method[] methods = clazz.getMethods();
            //元数据：描述数据的代码就是元数据
            //创建一个列名的集合对象
            List<String> columnNames = new ArrayList<String>();
            //获取结果集的元数据
            ResultSetMetaData metaData = rs.getMetaData();
            //获取数据表的列的个数
            int columnCount = metaData.getColumnCount();
            //获取数据表的列名
            for (int i = 1 ;i <= columnCount;i ++){
                //根据列的索引获取列名
                String columnName = metaData.getColumnName(i);
                columnNames.add(columnName);
            }
            while(rs.next()){
                //通过字节码创建对象
                Object o = clazz.newInstance();
                for (String columnName : columnNames) {
                    //通过列名获取某列的值
                    Object columnValue = rs.getObject(columnName);
                    //name id password  setName setId setPassword
                    //方法名：set + columnName
                    for (Method method : methods) {
                        //通过判断找到列名所对应的set方法：忽略大小写
                        if(method.getName().equalsIgnoreCase("set"+columnName)){
                            //执行相应 method方法
                            /**
                             * 参数1: 具体的对象
                             * 参数2：对象的方法的参数
                             */
                            method.invoke(o,columnValue);
                        }
                    }
                }
               list.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void close(){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stm != null){
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
