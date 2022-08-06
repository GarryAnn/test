package com.bean;

public class Tblpower {
  private long powerId;
  private String powerName;
  private String url;
  private long parentId;

  private long roleId;
  private String roleName;
  private String roleDescribe;

  private long rpId;


  public Tblpower() {
  }

  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleDescribe() {
    return roleDescribe;
  }

  public void setRoleDescribe(String roleDescribe) {
    this.roleDescribe = roleDescribe;
  }

  public long getRpId() {
    return rpId;
  }

  public void setRpId(long rpId) {
    this.rpId = rpId;
  }

  public long getPowerId() {
    return powerId;
  }

  public void setPowerId(long powerId) {
    this.powerId = powerId;
  }

  public String getPowerName() {
    return powerName;
  }

  public void setPowerName(String powerName) {
    this.powerName = powerName;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }

  @Override
  public String toString() {
    return "权限表{" +
            "权限ID=" + powerId +
            ", 权限名称='" + powerName + '\'' +
            ", 权限路径='" + url + '\'' +
            ", 权限父级ID=" + parentId +
            ", 角色ID=" + roleId +
            ", 角色名称='" + roleName + '\'' +
            ", 角色描述='" + roleDescribe + '\'' +
            ", 角色权限ID=" + rpId +
            '}';
  }
}
