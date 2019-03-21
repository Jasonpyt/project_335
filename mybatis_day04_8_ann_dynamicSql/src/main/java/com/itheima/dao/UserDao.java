package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.provider.UserDaoSqlProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface UserDao {
    /**
     * 多条件查询
     *  根据用户名模糊查询，根据性别查询
     *
     *  动态sql：@SelectProvider: 指定一个sql语句
     *      type：sql语句提供者类的字节码
     *      method:提供者的方法
     * @param user
     * @return
     */
//    @Select("select * from user where  uname like \"%\"#{uname}\"%\" and sex = #{sex}")
    @SelectProvider(type = UserDaoSqlProvider.class,method = "findAll")
    public List<User> findByParam(User user);


}
