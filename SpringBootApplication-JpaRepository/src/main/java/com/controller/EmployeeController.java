package com.controller;

import com.controller.forms.EmployeeForm;
import com.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @GetMapping("/home")
    public String getHomePage(ModelMap modelMap, @RequestParam(value = "success", required = false) String success,
                              @RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "id", required = false) String id) {
        EmployeeForm employeeForm = null;
        if (id != null) {
            try {
                Integer enId = Integer.parseInt(URLDecoder.decode(id, "UTF-8").replace("#/@:=/#", ""));
                employeeForm = employeeService.getService(enId);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            employeeForm = new EmployeeForm();
        }
        if (success != null)
            modelMap.addAttribute("success", success);

        if (error != null)
            modelMap.addAttribute("error", error);

        modelMap.addAttribute("employeeForm", employeeForm);
        return "employeePage.tiles";
    }

    @PostMapping(value = "/save")
    public String saveAndUpdateEmployee(ModelMap map,
                                        @ModelAttribute(value = "employeeForm") @Valid EmployeeForm employeeForm, BindingResult result) {
        if (result.hasErrors()) {
            map.addAttribute("error", "Binding error..");
            map.addAttribute("employeeForm", employeeForm);
            return "home";
        } else {
            Integer status = employeeService.saveService(employeeForm);
            if (status != null) {
                if (employeeForm.getId() == null) {
                    map.addAttribute("success", "Saved Successfully..");
                } else {
                    map.addAttribute("success", "Updated Successfully..");
                }
            } else {
                map.addAttribute("error", "Something went wrong...");
            }
        }
        return "redirect:/employee/home";
    }

    @GetMapping(value = "/delete")
    public String deleteEmployee(ModelMap map, @RequestParam(value = "id") String id) {
        Integer enId = null;
        try {
            enId = Integer.parseInt(URLDecoder.decode(id, "UTF-8").replace("#/@:=/#", ""));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (enId != null) {
            boolean status = employeeService.deleteService(enId);
            if (!status)
                map.addAttribute("success", "Deleted Successfully..");
        } else {
            map.addAttribute("error", "Something went wrong...");
        }

        return "redirect:/employee/home";
    }

    @ModelAttribute("employeeFormList")
    public List<EmployeeForm> getList() {
        return employeeService.getListService();
    }
}