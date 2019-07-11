package com.dao.impl;

import com.RepositoryManager.EntityDaoImpl;
import com.dao.UserRoleDao;
import com.dao.model.UserRoleMaster;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserRoleDaoImpl extends EntityDaoImpl<UserRoleMaster, Integer> implements UserRoleDao {
}
