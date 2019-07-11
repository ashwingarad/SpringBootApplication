package com.dao.impl;

import com.RepositoryManager.EntityDaoImpl;
import com.dao.RoleDao;
import com.dao.model.RoleMaster;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class RoleDaoImpl extends EntityDaoImpl<RoleMaster, Integer> implements RoleDao {

    @Override
    public List<RoleMaster> getRoleList() {
        CriteriaBuilder criteriaBuilder = createCriteriaBuilder();
        CriteriaQuery<RoleMaster> criteriaQuery = criteriaBuilder.createQuery(RoleMaster.class);
        criteriaQuery.from(RoleMaster.class);
        return createQuery(criteriaQuery).getResultList();
    }
}
