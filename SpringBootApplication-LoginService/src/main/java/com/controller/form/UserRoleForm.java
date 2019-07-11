package com.controller.form;

public class UserRoleForm {
    private Integer id;
    private UserProfileForm userProfileForm;
    private Integer userId;
    private RoleForm roleForm;
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserProfileForm getUserProfileForm() {
        return userProfileForm;
    }

    public void setUserProfileForm(UserProfileForm userProfileForm) {
        this.userProfileForm = userProfileForm;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public RoleForm getRoleForm() {
        return roleForm;
    }

    public void setRoleForm(RoleForm roleForm) {
        this.roleForm = roleForm;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
