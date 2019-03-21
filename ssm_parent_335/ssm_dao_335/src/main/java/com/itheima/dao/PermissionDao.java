package com.itheima.dao;

import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface PermissionDao {
    /**
     * 查询全部
     * @return
     */
    @Select("select * from sys_permission order by id ")
    List<Permission> findAll();

    /**
     * 查询父权限
     *
     * @return
     */
    @Select("select * from sys_permission where pid=0 ")
    List<Permission> findParentPermission();

    /**
     * 保存
     * @param permission
     */
    @Insert("insert into sys_permission values(#{id}, #{permissionName},#{url},#{pid})")
    @SelectKey(keyColumn = "id",keyProperty = "id",before = true,resultType = Integer.class,
    statement = "select permission_seq.nextval from dual")
    void save(Permission permission);


    /**
     * 根据角色id获取权限列表
     * @return
     */
    @Select("select p.* from sys_role_permission rp ,sys_permission p where rp.permissionid = p.id and rp.roleId = #{roleId}")
    public List<Permission> findPermissionListByRoleId(Integer roleId);
}
