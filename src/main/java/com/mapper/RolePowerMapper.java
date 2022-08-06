package com.mapper;

import com.bean.Tblpower;
import com.bean.Tblrole;
import com.bean.Tblrolepower;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePowerMapper {
    // 查询角色
    public List<Tblrole> findRole();
    // 查询权限
    public List<Tblpower> findPower();
    // 根据角色ID查该角色拥有的所有权限
    public List<Tblrole> findRoleAllPower(@Param("roleId") long roleId);
    // 添加权限
    public boolean addPower(@Param("roleId") long roleId,
                            @Param("powerId") long powerId);
    // 删除权限
    public boolean delPower(@Param("roleId") long roleId);
    // 查父权限下还有没有子权限
    public List<Tblpower> childPowerList(@Param("parentId") long parentId);
    // 判断该角色是否有该权限
    public List<Tblrolepower> findRolePower(@Param("roleId") long roleId,
                                            @Param("powerId") long powerId);



    // 角色管理：查
    public List<Tblrole> findAllRole(@Param("roleName")String roleName);
    // 角色数量
    public int roleCount();
    // 判断角色名是否已存在
    public List<Tblrole> checkRoleName(@Param("roleName")String roleName);
    // 角色管理：添加
    public boolean addRole(@Param("roleName")String roleName,
                           @Param("roleDescribe")String roleDescribe);
    // 角色管理：删
    public boolean delRole(@Param("roleId")long roleId);
    // 检测该角色是否已被使用
    public List<Tblrole> checkRole(@Param("roleId")long roleId);
    // 角色管理：修改
    public boolean updRole(@Param("RoleDescribe")String RoleDescribe,
                           @Param("roleId")long roleId);
}
