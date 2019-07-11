package com.controller;

import com.controller.form.UserForm;
import com.dao.model.UserMaster;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
public class UserLoginController {
    private static final Logger log = LogManager.getLogger(UserLoginController.class);

    @GetMapping("/homePage")
    public String userHomePage(ModelMap modelMap, HttpSession httpSession) {
        if (httpSession.getAttribute("userId") == null)
            return "redirect:/login";
        else {
            modelMap.addAttribute("userName", httpSession.getAttribute("currentUser"));
        }
        return "userHome.tiles";
    }

    @PostMapping(value = "/postLogin")
    public String userPostLogin(ModelMap modelMap, HttpSession httpSession) {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        validatePrinciple(authentication.getPrincipal());

        UserMaster userMaster = ((UserForm) authentication.getPrincipal()).getUserMaster();
        //modelMap.put("currentUserId", userMaster.getId());
        httpSession.setAttribute("currentUser", userMaster.getUserProfileMaster().getFirstName());
        httpSession.setAttribute("userId", userMaster.getId());
        return "redirect:/homePage";
    }

    private void validatePrinciple(Object principal) {
        if (!(principal instanceof UserForm)) {
            throw new IllegalArgumentException("Principal can not be null!");
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus session) {
        SecurityContextHolder.getContext().setAuthentication(null);
        session.setComplete();
        return "redirect:/login";
    }

    @GetMapping(value = "/loginFailed")
    public String loginError(Model model) {
        log.info("Login attempt failed");
        model.addAttribute("error", "true");
        return "userLogin.tiles";
    }

}
