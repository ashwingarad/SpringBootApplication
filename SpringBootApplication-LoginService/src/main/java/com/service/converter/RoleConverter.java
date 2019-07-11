package com.service.converter;

import com.controller.form.RoleForm;
import com.dao.model.RoleMaster;

public class RoleConverter {

    public static RoleForm fromRoleMasterToRoleForm(RoleMaster roleMaster) {
        RoleForm roleForm = null;
        if (roleMaster != null) {
            roleForm = new RoleForm();
            if (roleMaster.getId() != null)
                roleForm.setId(roleMaster.getId());
            roleForm.setRole_name(roleMaster.getRole_name());
        }
        return roleForm;
    }

    public static RoleMaster fromRoleFormToRoleMaster(RoleForm roleForm) {
        RoleMaster roleMaster = null;
        if (roleForm != null) {
            roleMaster = new RoleMaster();
            if (roleForm.getId() != null)
                roleMaster.setId(roleForm.getId());
            roleMaster.setRole_name(roleForm.getRole_name());
        }
        return roleMaster;
    }
}
