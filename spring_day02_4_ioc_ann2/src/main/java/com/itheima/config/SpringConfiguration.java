package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 *  @Configuration: spring的核心配置文件类--相当于applicationContext.xml
 *  @ComponentScan({"com.itheima"}):指定扫描的包的位置
 *  @Import():导入其他配置文件, 导入xml文件
 *  @Bean: 返回的对象会自动的存放到spring IOC容器中
 *  如果Bean标记在方法上，那么方法需要的参数会自动在容器中查找
 *  @Value:给简单类型的属性赋值
 * @PropertySource("classpath:jdbc.properties")：引入属性properties文件
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Configuration
@ComponentScan({"com.itheima"})
@Import({JDBCConfiguration.class})
public class SpringConfiguration {


}
