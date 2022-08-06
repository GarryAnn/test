package com.service;

import com.bean.Tbluser;

import java.util.List;

public interface UserService {
    // 登录
    public Tbluser login(String acc, String pwd);
    public boolean register(String acc, String pwd, String userName, String sex, long age, String url);
    // 检测帐号是否已存在
    public List<Tbluser> checkAcc(String acc);
    // 用户列表
    public List<Tbluser> findUser(String acc, String userName);
    // 用户列表总数
    public int userCount();
    // 新增用户
    public boolean confirmAddUser(String acc, String userName, String sex, long age, String address);
    // 删除用户
    public boolean delUser(long id);
    // 修改用户
    public boolean updUser(String pwd, String userName, String sex, long age, String address, long id);
}
