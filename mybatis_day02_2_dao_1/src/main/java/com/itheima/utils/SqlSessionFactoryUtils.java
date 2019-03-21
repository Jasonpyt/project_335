package com.itheima.utils;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//用于创建SqlSessionFactory对象
public class SqlSessionFactoryUtils {
    /**
     * 单例SqlSessionFactory
     */
    private static SqlSessionFactory sqlSessionFactory;

    static {
        // 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        try {
            // 查找配置文件创建输入流
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            // 加载配置文件，创建SqlSessionFactory对象
            sqlSessionFactory = sfb.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取单例SqlSessionFactory
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }


}
