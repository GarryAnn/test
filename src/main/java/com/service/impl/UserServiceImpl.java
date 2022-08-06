package com.service.impl;

import com.bean.Tbluser;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    // 登录
    @Override
    public Tbluser login(String acc, String pwd) {
        Tbluser tbluser = userMapper.login(acc, pwd);
        if (null != tbluser) {
            return tbluser;
        } else {
            Tbluser user = new Tbluser();
            return user;
        }
    }

    // 注册
    @Override
    public boolean register(String acc, String pwd, String userName, String sex, long age, String url) {
        boolean flag = userMapper.register(acc, pwd, userName, sex, age, url);
        return flag;
    }

    // 检测帐号是否已存在
    @Override
    public List<Tbluser> checkAcc(String acc) {
        return userMapper.checkAcc(acc);
    }

    @Override
    public List<Tbluser> findUser(String acc, String userName) {
        return userMapper.findUser(acc, userName);
    }

    // 用户列表总数
    @Override
    public int userCount() {
        return userMapper.userCount();
    }

    // 新增用户
    @Override
    public boolean confirmAddUser(String acc, String userName, String sex, long age, String address) {
        return userMapper.confirmAddUser(acc, userName, sex, age, address);
    }

    // 删除用户
    @Override
    public boolean delUser(long id) {
        return userMapper.delUser(id);
    }

    // 修改用户
    @Override
    public boolean updUser(String pwd, String userName, String sex, long age, String address, long id) {
        return userMapper.updUser(pwd, userName, sex, age, address, id);
    }
}
