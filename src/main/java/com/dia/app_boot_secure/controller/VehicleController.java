package com.dia.app_boot_secure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleController {
    @GetMapping("/vehicles")
    public String goVehicle() {
        return "vehicle";
    }
}
