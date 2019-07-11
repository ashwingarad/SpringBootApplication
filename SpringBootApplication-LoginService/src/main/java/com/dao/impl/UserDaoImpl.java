package com.dao.impl;

import com.RepositoryManager.EntityDaoImpl;
import com.dao.UserDao;
import com.dao.model.UserMaster;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserDaoImpl extends EntityDaoImpl<UserMaster, Integer> implements UserDao {

    @Override
    public UserMaster getUserByName(String username) {
        CriteriaBuilder builder = createCriteriaBuilder();
        CriteriaQuery<UserMaster> query = builder.createQuery(UserMaster.class);
        Root<UserMaster> root = query.from(UserMaster.class);
        query.where(builder.equal(root.get("username"), username));
        return (UserMaster) createQuery(query).uniqueResult();
    }
}
