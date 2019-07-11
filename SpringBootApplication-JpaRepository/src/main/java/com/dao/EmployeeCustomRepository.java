package com.dao;

import com.model.EmployeeMaster;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCustomRepository {
    public List<EmployeeMaster> getEmployeeList();
}
