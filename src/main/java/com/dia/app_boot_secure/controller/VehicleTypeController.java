package com.dia.app_boot_secure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleTypeController {
    @GetMapping("/vehicletypes")
    public String goVehicletype() {
        return "vehicletype";
    }
}
