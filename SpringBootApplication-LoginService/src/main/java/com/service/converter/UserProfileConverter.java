package com.service.converter;

import com.controller.form.UserProfileForm;
import com.dao.model.UserProfileMaster;

public class UserProfileConverter {

    public static UserProfileMaster fromUserProfileFormToUserProfileMaster(UserProfileForm userProfileForm) {
        UserProfileMaster userProfileMaster = null;
        if (userProfileForm != null) {
            userProfileMaster = new UserProfileMaster();

            if (userProfileForm.getId() != null)
                userProfileMaster.setId(userProfileForm.getId());

            userProfileMaster.setEmailId(userProfileForm.getEmailId());
            userProfileMaster.setFirstName(userProfileForm.getFirstName());
            userProfileMaster.setLastName(userProfileForm.getLastName());
            userProfileMaster.setMobile(userProfileForm.getMobile());
        }
        return userProfileMaster;
    }

    public static UserProfileForm fromUserProfileMasterToUserProfileForm(UserProfileMaster userProfileMaster) {
        UserProfileForm userProfileForm = null;
        if (userProfileMaster != null) {
            userProfileForm = new UserProfileForm();

            if (userProfileMaster.getId() != null)
                userProfileForm.setId(userProfileMaster.getId());

            userProfileForm.setEmailId(userProfileMaster.getEmailId());
            userProfileForm.setFirstName(userProfileMaster.getFirstName());
            userProfileForm.setLastName(userProfileMaster.getLastName());
            userProfileForm.setMobile(userProfileMaster.getMobile());
        }
        return userProfileForm;
    }
}
