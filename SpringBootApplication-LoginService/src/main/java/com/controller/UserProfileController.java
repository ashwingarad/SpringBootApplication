package com.controller;

import com.controller.form.RoleForm;
import com.controller.form.UserProfileForm;
import com.service.RoleService;
import com.service.UserProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserProfileController {

    @Resource
    private UserProfileService userProfileService;

    @Resource
    private RoleService roleService;

    @GetMapping(value = "/signup")
    public String registrationPage(@RequestParam(name = "success", required = false) String success,
                                   @RequestParam(name = "error", required = false) String error,
                                   ModelMap modelMap) {
        if (success != null)
            modelMap.addAttribute("success", success);
        if (error != null)
            modelMap.addAttribute("error", error);
        modelMap.addAttribute("userProfileForm", new UserProfileForm());
        return "userProfile.tiles";
    }

    @PostMapping(value = "/registerUser")
    public String register(ModelMap map, @Valid @ModelAttribute(value = "userProfileForm") UserProfileForm userProfileForm, BindingResult result) {
        if (result.hasErrors()) {
            map.addAttribute("error", "Binding error..!");
            map.addAttribute("userProfileForm", userProfileForm);
            return "userProfile.tiles";
        } else {
            Integer pk = userProfileService.saveUser(userProfileForm);
            if (pk != null)
                map.addAttribute("success", "User Created...!");
            else
                map.addAttribute("error", "Something went wrong..!");
        }
        return "redirect:/user/signup";
    }

    @ModelAttribute("roleFormList")
    public List<RoleForm> roleFormList() {
        return roleService.getRoleList();
    }
}
