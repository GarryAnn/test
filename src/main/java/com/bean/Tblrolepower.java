package com.bean;

public class Tblrolepower {
  private long rpId;
  private long roleId;
  private long powerId;

  private String powerName;
  private String url;
  private long parentId;

  private String roleName;
  private String roleDescribe;


  public Tblrolepower() {
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

  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }

  public long getPowerId() {
    return powerId;
  }

  public void setPowerId(long powerId) {
    this.powerId = powerId;
  }

  @Override
  public String toString() {
    return "Tblrolepower{" +
            "rpId=" + rpId +
            ", roleId=" + roleId +
            ", powerId=" + powerId +
            ", powerName='" + powerName + '\'' +
            ", url='" + url + '\'' +
            ", parentId=" + parentId +
            ", roleName='" + roleName + '\'' +
            ", roleDescribe='" + roleDescribe + '\'' +
            '}';
  }
}
