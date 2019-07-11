package com.service;

import com.controller.form.RoleForm;
import com.dao.model.RoleMaster;

import java.util.List;

public interface RoleService {
    public List<RoleForm> getRoleList();

    public RoleMaster getRoleById(Integer id);
}
