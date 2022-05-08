package com.dia.app_boot_secure.controller;

import com.dia.app_boot_secure.model.Country;
import com.dia.app_boot_secure.model.Employee;
import com.dia.app_boot_secure.model.State;
import com.dia.app_boot_secure.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired private EmployeeService employeeService;
    @Autowired private StateService stateService;
    @Autowired private JobTitleService jobTitleService;
    @Autowired private CountryService countryService;
    @Autowired private EmployeeTypeService employeeTypeService;

    @Autowired private ServletContext context;

    // Get All State
    @GetMapping("/employees")
    public String goStates(Model model) {

        model.addAttribute("employees",employeeService.getEmployee());;
        model.addAttribute("countries",countryService.getCountries());
        model.addAttribute("jobTitles", jobTitleService.getJobTitle());
        model.addAttribute("states",stateService.getStates());
        model.addAttribute("employeeTypes", employeeTypeService.getEmployeeType());

        return "employee";
        //}
    }

    @PostMapping("/employees/addNew")
    public String saveEmployee(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping("employees/findById")
    @ResponseBody
    public Optional<Employee> findById(int id) {
        return employeeService.findById(id);
    }

    @RequestMapping(value = "employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
