package com.dao.impl;

import com.RepositoryManager.EntityDaoImpl;
import com.dao.UserProfileDao;
import com.dao.model.UserProfileMaster;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserProfileDaoImpl extends EntityDaoImpl<UserProfileMaster, Integer> implements UserProfileDao {

    @Override
    public List<UserProfileMaster> getAllUsers() {
        CriteriaBuilder criteriaBuilder = createCriteriaBuilder();
        CriteriaQuery<UserProfileMaster> criteriaQuery = criteriaBuilder.createQuery(UserProfileMaster.class);
        criteriaQuery.from(UserProfileMaster.class);
        return createQuery(criteriaQuery).getResultList();
    }
}
