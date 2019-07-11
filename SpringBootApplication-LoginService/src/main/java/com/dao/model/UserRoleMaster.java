package com.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRoleMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserProfileMaster userProfileMaster;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Integer userId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private RoleMaster roleMaster;

    @Column(name = "role_id", insertable = false, updatable = false)
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserProfileMaster getUserProfileMaster() {
        return userProfileMaster;
    }

    public void setUserProfileMaster(UserProfileMaster userProfileMaster) {
        this.userProfileMaster = userProfileMaster;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public RoleMaster getRoleMaster() {
        return roleMaster;
    }

    public void setRoleMaster(RoleMaster roleMaster) {
        this.roleMaster = roleMaster;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
