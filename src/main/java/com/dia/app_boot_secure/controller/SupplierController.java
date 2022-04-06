package com.dia.app_boot_secure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupplierController {
    @GetMapping("suppliers")
    public String goLocation() {
        return "supplier";
    }
}
