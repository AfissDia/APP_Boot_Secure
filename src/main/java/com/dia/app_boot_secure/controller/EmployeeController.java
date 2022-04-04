package com.dia.app_boot_secure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @GetMapping("/employees")
    public String goEmployee() {
        return "employee";
    }
}
