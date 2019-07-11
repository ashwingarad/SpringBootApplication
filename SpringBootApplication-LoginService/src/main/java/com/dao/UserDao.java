package com.dao;

import com.RepositoryManager.EntityDao;
import com.dao.model.UserMaster;

public interface UserDao extends EntityDao<UserMaster, Integer> {
    public UserMaster getUserByName(String username);
}
