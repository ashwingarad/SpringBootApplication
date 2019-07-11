package com.service;

import com.controller.form.UserProfileForm;

import java.util.List;

public interface UserProfileService {
    public UserProfileForm getUserById(Integer id);

    public void deleteUser(Integer id);

    public Integer saveUser(UserProfileForm userProfileForm);

    public List<UserProfileForm> getAllUsers();
}
