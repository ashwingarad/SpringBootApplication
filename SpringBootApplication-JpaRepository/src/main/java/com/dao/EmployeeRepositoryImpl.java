package com.dao;

import com.model.EmployeeMaster;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeRepositoryImpl implements EmployeeCustomRepository {

    @Resource
    EntityManager entityManager;

    @Override
    public List<EmployeeMaster> getEmployeeList() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmployeeMaster> query = builder.createQuery(EmployeeMaster.class);
        query.from(EmployeeMaster.class);
        return entityManager.createQuery(query).getResultList();
    }
}
