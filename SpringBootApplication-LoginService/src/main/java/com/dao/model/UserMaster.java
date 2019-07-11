package com.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "user_login")
public class UserMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "pass")
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserProfileMaster userProfileMaster;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserProfileMaster getUserProfileMaster() {
        return userProfileMaster;
    }

    public void setUserProfileMaster(UserProfileMaster userProfileMaster) {
        this.userProfileMaster = userProfileMaster;
    }
}
