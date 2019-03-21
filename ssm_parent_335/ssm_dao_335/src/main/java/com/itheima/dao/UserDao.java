package com.itheima.dao;

import com.itheima.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * 登录操作：用户的状态为可用
     * @param username
     * @return
     */
    @Select("select * from sys_user where username = #{abc} and status = 1")
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "roleList",column = "id",
                    many = @Many(select = "com.itheima.dao.RoleDao.findRoleListByUserId",fetchType = FetchType.LAZY))
    })
    SysUser findByUsername(String username);

    /**
     * 查询用户名是否存在，不考虑是否可用
     * @param username
     * @return
     */
    @Select("select * from sys_user where username = #{abc}")
    SysUser checkName(String username);

    /**
     * 查询全部
     * @return
     */
    @Select("select * from sys_user")
    List<SysUser> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into sys_user values(user_seq.nextval,#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(SysUser user);


    /**
     * 根据id查询
     * @param id
     * @return
     *
     * SysUser对象中有roleList属性，属性与列不对应，需要做结果映射
     *
     * select: mapperId = namespace  + id = 接口的全名称 + 方法的名称
     */
    @Select("select * from sys_user where id = #{id}")
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "roleList",column = "id",
                    many = @Many(select = "com.itheima.dao.RoleDao.findRoleListByUserId",fetchType = FetchType.LAZY))
    })
    SysUser findById(Integer id);
    /**
     * 移除用户原有的角色关系
     * @param userId
     */
    @Delete("delete from sys_user_role where userId = #{userId}")
    void removeAllRoleFromUser(Integer userId);

    /**
     * 维护新的关系
     * @param roleId
     * @param userId
     */
    @Insert("insert into sys_user_role values(#{param2},#{param1})")
    void addRoleToUser(Integer roleId, Integer userId);
}
