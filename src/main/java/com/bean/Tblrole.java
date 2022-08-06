package com.bean;

public class Tblrole {
  private long roleId;
  private String roleName;
  private String roleDescribe;

  private long powerId;
  private String powerName;
  private String url;
  private long parentId;

  private long rpId;

  public Tblrole() {
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

  @Override
  public String toString() {
    return "Tblrole{" +
            "roleId=" + roleId +
            ", roleName='" + roleName + '\'' +
            ", roleDescribe='" + roleDescribe + '\'' +
            ", powerId=" + powerId +
            ", powerName='" + powerName + '\'' +
            ", url='" + url + '\'' +
            ", parentId=" + parentId +
            ", rpId=" + rpId +
            '}';
  }
}
