package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface UserDao {



    /**
     * 查询所的用户，包含账户信息
     * many:映射一个集合对象
     * 在注解中如果相同可以不做映射, 在xml中，如果配置了一对一，一对多所有的都必须配置
     * mybatis列原本只能映射一个属性,如果要映射两个属性，则必须都配置
     * @return
     */
    @Select("select * from user")
    @Results({
            @Result(id = true,column = "uid",property = "uid"),
            @Result(property = "accountList",column = "uid",javaType = List.class,
            many = @Many(select = "com.itheima.dao.AccountDao.findByUserId",fetchType = FetchType.LAZY))
    })
    public List<User> findAll();
}
