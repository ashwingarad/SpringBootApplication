package com.dao;

import com.RepositoryManager.EntityDao;
import com.dao.model.UserProfileMaster;

import java.util.List;

public interface UserProfileDao extends EntityDao<UserProfileMaster, Integer> {
    public List<UserProfileMaster> getAllUsers();
}