package com.service;

import com.controller.converter.EmployeeConverter;
import com.controller.forms.EmployeeForm;
import com.dao.EmployeeRepository;
import com.model.EmployeeMaster;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ashwin
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeRepository employeeRepository;

    @Override
    public Integer saveService(EmployeeForm employeeForm) {
        EmployeeMaster employeeMaster = EmployeeConverter.getEmployeeMasterFromEmployeeForm(employeeForm);
        employeeRepository.save(employeeMaster);
        return employeeMaster.getId();
    }

    @Override
    public boolean deleteService(Integer id) {
        employeeRepository.deleteById(id);
        return employeeRepository.existsById(id);
    }

    @Override
    public EmployeeForm getService(Integer id) {
        EmployeeMaster employeeMaster = null;
        if (employeeRepository.existsById(id))
            employeeMaster = employeeRepository.getOne(id);
        return EmployeeConverter.getEmployeeFormFromEmployeeMaster(employeeMaster);
    }

    @Override
    public List<EmployeeForm> getListService() {
        List<EmployeeMaster> employeeMasterList = employeeRepository.getEmployeeList();
        List<EmployeeForm> employeeFormList = new ArrayList<>();
        employeeMasterList.forEach(employeeMaster -> {
            EmployeeForm employeeForm = EmployeeConverter.getEmployeeFormFromEmployeeMaster(employeeMaster);
            employeeFormList.add(employeeForm);
        });
        return employeeFormList;
    }
}