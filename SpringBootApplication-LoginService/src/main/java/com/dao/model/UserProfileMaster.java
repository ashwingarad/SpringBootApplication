package com.dao.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "user_profile")
@Cacheable
public class UserProfileMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(length = 255)
    private String mobile;

    @Column(name = "email_id")
    @Email
    private String emailId;

    @OneToOne(mappedBy = "userProfileMaster", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserMaster userMaster;

    @OneToMany(mappedBy = "userProfileMaster", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    @LazyCollection(LazyCollectionOption.EXTRA)
    private List<UserRoleMaster> userRoleMasterList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public UserMaster getUserMaster() {
        return userMaster;
    }

    public void setUserMaster(UserMaster userMaster) {
        this.userMaster = userMaster;
    }

    public List<UserRoleMaster> getUserRoleMasterList() {
        return userRoleMasterList;
    }

    public void setUserRoleMasterList(List<UserRoleMaster> userRoleMasterList) {
        this.userRoleMasterList = userRoleMasterList;
    }
}
