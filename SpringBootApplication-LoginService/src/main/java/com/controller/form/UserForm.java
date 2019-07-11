package com.controller.form;

import com.dao.model.UserMaster;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserForm implements UserDetails {

    private UserMaster userMaster;

    public UserForm(UserMaster userMaster) {
        this.userMaster = userMaster;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userMaster.getUserProfileMaster().getUserRoleMasterList().stream().map(authority ->
                new SimpleGrantedAuthority(authority.getRoleMaster().getRole_name())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return userMaster.getPassword();
    }

    @Override
    public String getUsername() {
        return userMaster.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserMaster getUserMaster() {
        return userMaster;
    }
}
