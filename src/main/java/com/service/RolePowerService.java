package com.service;

import com.bean.Tblpower;
import com.bean.Tblrole;
import com.bean.Tblrolepower;

import java.util.List;

public interface RolePowerService {
    // 查询角色
    public List<Tblrole> findRole();
    // 查询权限
    public List<Tblpower> findPower();
    // 根据角色ID查该角色拥有的所有权限
    public List<Tblrole> findRoleAllPower(long roleId);
    // 添加权限
    public boolean addPower(long roleId, long powerId);
    // 删除权限
    public boolean delPower(long roleId);
    // 查父权限下还有没有子权限
    public List<Tblpower> childPowerList(long parentId);
    // 判断该角色是否有该权限
    public List<Tblrolepower> findRolePower(long roleId, long powerId);



    // 角色管理：查
    public List<Tblrole> findAllRole(String roleName);
    // 角色数量
    public int roleCount();
    // 判断角色名是否已存在
    public List<Tblrole> checkRoleName(String roleName);
    // 角色管理：添加
    public boolean addRole(String roleName, String roleDescribe);
    // 角色管理：删
    public boolean delRole(long roleId);
    // 检测该角色是否已被使用
    public List<Tblrole> checkRole(long roleId);
    // 角色管理：修改
    public boolean updRole(String RoleDescribe, long roleId);
}
