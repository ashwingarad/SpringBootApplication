package com.controller.converter;

import com.controller.forms.EmployeeForm;
import com.model.EmployeeMaster;

public class EmployeeConverter {

    public static EmployeeMaster getEmployeeMasterFromEmployeeForm(EmployeeForm employeeForm) {
        EmployeeMaster employeeMaster = new EmployeeMaster();
        if (employeeForm != null) {
            if (employeeForm.getId() != null)
                employeeMaster.setId(employeeForm.getId());
            employeeMaster.setEname(employeeForm.getEname());
            employeeMaster.setSalary(employeeForm.getSalary());
        }
        return employeeMaster;
    }

    public static EmployeeForm getEmployeeFormFromEmployeeMaster(EmployeeMaster employeeMaster) {
        EmployeeForm employeeForm = new EmployeeForm();
        if (employeeMaster != null) {
            if (employeeMaster.getId() != null)
                employeeForm.setId(employeeMaster.getId());
            employeeForm.setEname(employeeMaster.getEname());
            employeeForm.setSalary(employeeMaster.getSalary());
        }
        return employeeForm;
    }
}
