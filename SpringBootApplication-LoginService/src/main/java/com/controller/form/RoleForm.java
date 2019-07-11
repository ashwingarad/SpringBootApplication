package com.controller.form;

import java.util.List;

public class RoleForm {
    private Integer id;
    private String role_name;
    private List<UserRoleForm> userRoleFormList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public List<UserRoleForm> getUserRoleFormList() {
        return userRoleFormList;
    }

    public void setUserRoleFormList(List<UserRoleForm> userRoleFormList) {
        this.userRoleFormList = userRoleFormList;
    }
}
