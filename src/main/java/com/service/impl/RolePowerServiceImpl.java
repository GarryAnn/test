package com.service.impl;

import com.bean.Tblpower;
import com.bean.Tblrole;
import com.bean.Tblrolepower;
import com.mapper.RolePowerMapper;
import com.service.RolePowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePowerServiceImpl implements RolePowerService {
    @Autowired
    private RolePowerMapper mapper;

    // 查询角色
    @Override
    public List<Tblrole> findRole() {
        return mapper.findRole();
    }

    // 查询权限
    @Override
    public List<Tblpower> findPower() {
        return mapper.findPower();
    }

    // 根据角色ID查该角色拥有的所有权限
    @Override
    public List<Tblrole> findRoleAllPower(long roleId) {
        return mapper.findRoleAllPower(roleId);
    }

    // 添加权限
    @Override
    public boolean addPower(long roleId, long powerId) {
        return mapper.addPower(roleId, powerId);
    }

    // 删除权限
    @Override
    public boolean delPower(long roleId) {
        return mapper.delPower(roleId);
    }

    // 查父权限下还有没有子权限
    @Override
    public List<Tblpower> childPowerList(long parentId) {
        return mapper.childPowerList(parentId);
    }

    // 判断该角色是否有该权限
    @Override
    public List<Tblrolepower> findRolePower(long roleId, long powerId) {
        return mapper.findRolePower(roleId, powerId);
    }



    // 角色管理：查
    @Override
    public List<Tblrole> findAllRole(String roleName) {
        return mapper.findAllRole(roleName);
    }

    // 角色数量
    @Override
    public int roleCount() {
        return mapper.roleCount();
    }

    // 判断角色名是否已存在
    @Override
    public List<Tblrole> checkRoleName(String roleName) {
        return mapper.checkRoleName(roleName);
    }

    // 角色管理：添加
    @Override
    public boolean addRole(String roleName, String roleDescribe) {
        return mapper.addRole(roleName, roleDescribe);
    }

    // 角色管理：删
    @Override
    public boolean delRole(long roleId) {
        return mapper.delRole(roleId);
    }

    // 检测该角色是否已被使用
    @Override
    public List<Tblrole> checkRole(long roleId) {
        return mapper.checkRole(roleId);
    }

    // 角色管理：修改
    @Override
    public boolean updRole(String RoleDescribe, long roleId) {
        return mapper.updRole(RoleDescribe, roleId);
    }
}
