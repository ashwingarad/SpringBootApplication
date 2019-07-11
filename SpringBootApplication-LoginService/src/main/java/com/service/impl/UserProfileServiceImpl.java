package com.service.impl;

import com.controller.form.UserProfileForm;
import com.dao.RoleDao;
import com.dao.UserProfileDao;
import com.dao.UserRoleDao;
import com.dao.model.RoleMaster;
import com.dao.model.UserMaster;
import com.dao.model.UserProfileMaster;
import com.dao.model.UserRoleMaster;
import com.service.UserProfileService;
import com.service.converter.UserProfileConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Resource
    private BCryptPasswordEncoder encoder;

    @Resource
    private UserProfileDao userProfileDao;

    @Resource
    private RoleDao roleDao;

    @Resource
    private UserRoleDao userRoleDao;

    @Override
    public UserProfileForm getUserById(Integer id) {
        return null;
    }

    @Override
    public void deleteUser(Integer id) {

    }

    @Override
    public Integer saveUser(UserProfileForm userProfileForm) {
        Integer flag = 0;
        UserProfileMaster userProfileMaster = UserProfileConverter.fromUserProfileFormToUserProfileMaster(userProfileForm);
        UserMaster userMaster = new UserMaster();
        userMaster.setUsername(userProfileForm.getUsername());
        userMaster.setPassword(encoder.encode(userProfileForm.getPassword()));
        userMaster.setUserProfileMaster(userProfileMaster);
        userProfileMaster.setUserMaster(userMaster);
        Integer uid = userProfileDao.create(userProfileMaster);
        if (uid != null) {

            List<UserRoleMaster> roleMasterList = new ArrayList<>();
            UserRoleMaster userRoleMaster = new UserRoleMaster();
            RoleMaster roleMaster = roleDao.load(userProfileForm.getRoleId());
            userRoleMaster.setRoleMaster(roleMaster);

            UserProfileMaster userProfileMaster2 = userProfileDao.load(uid);
            userRoleMaster.setUserProfileMaster(userProfileMaster2);
            roleMasterList.add(userRoleMaster);

            Integer urid = userRoleDao.create(userRoleMaster);
            if (urid != null && urid > 0)
                flag = uid;
        }
        return flag;
    }

    @Override
    public List<UserProfileForm> getAllUsers() {
        List<UserProfileForm> profileFormList = new ArrayList<>();
        List<UserProfileMaster> profileMasterList = userProfileDao.getAllUsers();
        for (UserProfileMaster userProfileMaster : profileMasterList) {
            profileFormList.add(UserProfileConverter.fromUserProfileMasterToUserProfileForm(userProfileMaster));
        }
        return profileFormList;
    }
}
