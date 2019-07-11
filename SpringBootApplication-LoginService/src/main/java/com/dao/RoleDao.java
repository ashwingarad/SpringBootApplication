package com.dao;

import com.RepositoryManager.EntityDao;
import com.dao.model.RoleMaster;

import java.util.List;

public interface RoleDao extends EntityDao<RoleMaster, Integer> {
    public List<RoleMaster> getRoleList();
}
