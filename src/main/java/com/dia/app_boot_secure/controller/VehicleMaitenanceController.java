package com.dia.app_boot_secure.controller;

import com.dia.app_boot_secure.model.VehicleMaintenance;
import com.dia.app_boot_secure.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMaitenanceController {
    @Autowired
    private VehicleMaintenanceService vehicleMaintenanceService;
    @Autowired private VehicleService vehicleService;
    @Autowired private SupplierService supplierService;

    @GetMapping("/vehicleMaintenances")
    public String goVehicleMaintenances(Model model) {
        model.addAttribute("vehicleMaintenances",vehicleMaintenanceService.getVehicleMaintenances());;

        model.addAttribute("vehicles", vehicleService.getVehicles());

        model.addAttribute("suppliers",supplierService.getSuppliers());

        return "vehicleMaintenance";
        //}
    }

    @PostMapping("/vehicleMaintenances/addNew")
    public String saveVehicleMaintenances(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }

    @RequestMapping("vehicleMaintenances/findById")
    @ResponseBody
    public Optional<VehicleMaintenance> findById(int id) {
        return vehicleMaintenanceService.findById(id);
    }

    @RequestMapping(value = "vehicleMaintenances/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }
    @RequestMapping(value = "vehicleMaintenances/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMaintenanceService.delete(id);
        return "redirect:/vehicleMaintenances";
    }
}
