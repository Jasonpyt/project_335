package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface AccountDao {

    /**
     * 根据用户的id查询获取多个账户信息
     * @param userId
     * @return
     */
    @Select("select * from account where userId = #{userId}")
    @Results({
            @Result(id = true,column = "aid",property = "id"),
            @Result(column = "aname",property = "accountName")
    })
    public List<Account> findByUserId(Integer userId);




}
