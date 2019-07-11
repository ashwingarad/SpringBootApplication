package com.dao.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class RoleMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String role_name;

    @OneToMany(mappedBy = "roleMaster", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.EXTRA)
    private List<UserRoleMaster> userRoleMasterList;

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

    public List<UserRoleMaster> getUserRoleMasterList() {
        return userRoleMasterList;
    }

    public void setUserRoleMasterList(List<UserRoleMaster> userRoleMasterList) {
        this.userRoleMasterList = userRoleMasterList;
    }
}
