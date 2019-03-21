package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AccountDao {
    //查询全部
    @Select("Select * from account")
    @Results({
            @Result(id = true, column = "aid", property = "id"),
            @Result(column = "aname", property = "accountName")

    })
    public List<Account> findAll();

    @Select("select * from account where aid = #{abc}")
    @Results({
            @Result(id = true, column = "aid", property = "id"),
            @Result(column = "aname", property = "accountName")

    })
    public Account findById(Integer id);


    /**
     * 保存
     *
     * @param account
     * @SelectKey :回显主键
     * 属性：
     * keyColumn：主键的列名
     * keyProperty :主键的属性名
     * before: 在之前还是之后获取主键
     * resultType: 返回值类型
     */
    @Insert("insert into account values(null ,#{accountName},#{userId})")
    @SelectKey(keyColumn = "aid", keyProperty = "id", before = false, resultType = int.class,
            statement = "select last_insert_id()")
    public void insert(Account account);


    @Update("update account set aname = #{accountName},userId = #{userId} where aid = #{id} ")
    @Results({
            @Result(id = true, column = "aid", property = "id"),
            @Result(column = "aname", property = "accountName")

    })
    public void update(Account account);

@Delete("delete from account where aid = #{aid}")
    public void delById(Integer id);

@Select("select * from account where aname like \"%\"#{name}\"%\" ")
public List<Account>findByName(String name);
}




