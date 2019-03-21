package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface RoleDao {
    /**
     * 查询全部
     * @return
     */
    @Select("select * from sys_role")
    List<Role> findAll();

    /**
     * 保存角色
     * @param role
     */
    @Insert("insert into sys_role values(role_seq.nextval, #{roleName},#{roleDesc})")
    void save(Role role);


    /**
     * 根据用户id查询角色列表
     * @param userId
     * @return
     *
     * 角色中包含权限列表信息，需要权限，结果映射权限信息
     */
    @Select("select r.* from sys_role r,sys_user_role ur where ur.roleId = r.id and ur.userId = #{userId}")
    @Results({
            //id列使用两次，所有即使属性名与列名相同，也必须做明确的映射
            @Result(property = "id",column = "id",id = true),
            @Result(property = "permissionList",column = "id",javaType = List.class,
                    many = @Many(select = "com.itheima.dao.PermissionDao.findPermissionListByRoleId",fetchType = FetchType.LAZY))
    })
    public List<Role> findRoleListByUserId(Integer userId);


    /**
     * 根据id查询角色
     *  需要包含权限信息，需要做结果映射
     * @param roleId
     * @return
     */
    @Select("select * from sys_role where id = #{roleId}")
    @Results({
            //id列使用两次，所有即使属性名与列名相同，也必须做明确的映射
            @Result(property = "id",column = "id",id = true),
            @Result(property = "permissionList",column = "id",javaType = List.class,
                    many = @Many(select = "com.itheima.dao.PermissionDao.findPermissionListByRoleId",fetchType = FetchType.LAZY))
    })
    Role findById(Integer roleId);
    /**
     * 删除原来的关系
     * @param roleId
     */
    @Delete("delete from sys_role_permission where roleId = #{roleId}")
    void removePermissionListFromRole(Integer roleId);

    /**
     * 添加新的关系
     * @param permissionId
     * @param roleId
     */
    @Insert("insert into sys_role_permission(permissionId,roleId) values(#{param1},#{param2})")
    void addPermissionToRole(Integer permissionId, Integer roleId);
}
