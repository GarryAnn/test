package com.bean;

public class Tbluser {
  private long id;
  private long roleId;
  private String acc;
  private String pwd;
  private String userName;
  private String sex;
  private long age;
  private String url;
  private String address;

  public Tbluser() {
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAcc() {
    return acc;
  }

  public void setAcc(String acc) {
    this.acc = acc;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "Tbluser{" +
            "id=" + id +
            ", 角色ID='" + roleId + '\'' +
            ", 帐号='" + acc + '\'' +
            ", 密码='" + pwd + '\'' +
            ", 姓名='" + userName + '\'' +
            ", 性别='" + sex + '\'' +
            ", 年龄=" + age +
            ", 头绪='" + url + '\'' +
            '}';
  }
}
