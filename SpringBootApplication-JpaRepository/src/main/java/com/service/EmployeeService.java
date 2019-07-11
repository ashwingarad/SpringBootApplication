/**
 * SpringMVC-AjaxWithHibernate
 */
package com.service;

import com.controller.forms.EmployeeForm;

import java.util.List;

/**
 * @author Ashwin
 */
public interface EmployeeService {
    public Integer saveService(EmployeeForm employeeForm);

    public boolean deleteService(Integer id);

    public EmployeeForm getService(Integer id);

    public List<EmployeeForm> getListService();
}
