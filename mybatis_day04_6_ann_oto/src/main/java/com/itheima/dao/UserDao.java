package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    /**
     * 根据id获取用户对象
     * @param id
     * @return
     */
    @Select("SELECT * FROM user WHERE uid = #{id}")
    public User findById(Integer id);
}
