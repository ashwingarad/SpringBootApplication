package com.service.impl;

import com.controller.form.RoleForm;
import com.dao.RoleDao;
import com.dao.model.RoleMaster;
import com.service.RoleService;
import com.service.converter.RoleConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    public List<RoleForm> getRoleList() {
        List<RoleForm> roleFormList = new ArrayList<>();
        List<RoleMaster> roleMasterList = roleDao.getRoleList();
        for (RoleMaster roleMaster : roleMasterList) {
            roleFormList.add(RoleConverter.fromRoleMasterToRoleForm(roleMaster));
        }
        return roleFormList;
    }

    @Override
    public RoleMaster getRoleById(Integer id) {
        return roleDao.load(id);
    }
}
