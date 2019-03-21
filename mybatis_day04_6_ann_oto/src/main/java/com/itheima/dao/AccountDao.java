package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    /**
     * 获取所有的账户信息，包括用户信息
     * @return
     */
    @Results({
            @Result(id = true, column = "aid", property = "id"),
            @Result(column = "aname", property = "accountName"),
            @Result(column = "userId", property ="user",javaType = User.class,one = @One (select = "com.itheima.dao.UserDao.findById",fetchType = FetchType.LAZY))

    }
    )
    @Select("SELECT * FROM account ")
    public List<Account>findAll();
}
