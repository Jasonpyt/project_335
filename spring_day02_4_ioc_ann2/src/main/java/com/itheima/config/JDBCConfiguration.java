package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * JDBC的配置文件
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@PropertySource("classpath:jdbc.properties")
public class JDBCConfiguration {

    @Value("${jdbc.driver}")
    private String driverClass;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.user}")
    private String user;

    //创建数据源对象
    @Bean("dataSource")
    public DataSource createDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl(url);
        try {
            dataSource.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }
    //创建queryRunner对象
    @Bean("queryRunner")
    public QueryRunner createQueryRunner(DataSource dataSource){
        QueryRunner queryRunner =new QueryRunner(dataSource);
        return queryRunner;
    }
}
