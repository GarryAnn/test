package com.mapper;

import com.bean.Tbluser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    // 登录
    public Tbluser login(@Param("acc") String acc,
                         @Param("pwd") String pwd);
    // 注册
    public boolean register(@Param("acc") String acc,
                            @Param("pwd") String pwd,
                            @Param("userName") String userName,
                            @Param("sex") String sex,
                            @Param("age") long age,
                            @Param("url") String url);
    // 检测帐号是否已存在
    public List<Tbluser> checkAcc(@Param("acc") String acc);
    // 用户列表
    public List<Tbluser> findUser(@Param("acc")String acc,
                                  @Param("userName")String userName);
    // 用户列表总条数
    public int userCount();
    // 新增用户
    public boolean confirmAddUser(@Param("acc")String acc,
                                  @Param("userName")String userName,
                                  @Param("sex")String sex,
                                  @Param("age")long age,
                                  @Param("address")String address);
    // 删除用户
    public boolean delUser(@Param("id")long id);
    // 修改用户
    public boolean updUser(@Param("pwd")String pwd,
                           @Param("userName")String userName,
                           @Param("sex")String sex,
                           @Param("age")long age,
                           @Param("address")String address,
                           @Param("id")long id);
}
