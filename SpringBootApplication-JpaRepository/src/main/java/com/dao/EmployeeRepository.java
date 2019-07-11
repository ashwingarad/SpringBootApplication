package com.dao;

import com.model.EmployeeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeMaster, Integer>, EmployeeCustomRepository {
}
