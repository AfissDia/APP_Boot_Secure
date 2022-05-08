package com.dia.app_boot_secure.controller;

import com.dia.app_boot_secure.model.Vehicle;
import com.dia.app_boot_secure.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleController {
    // vehicle model
    // vehicle make
    // vehicle make
    // vehicle status
    // employeee
    @Autowired private VehicleService vehicleService;
    @Autowired private VehicleModelService vehicleModelService;
    @Autowired private VehicleHireService vehicleHireService;
    @Autowired private VehicleMakeService vehicleMakeService;
    @Autowired private VehicleStatusService vehicleStatusService;
    @Autowired private VehicleTypeService vehicleTypeService;
    @Autowired private EmployeeService employeeService;
    @Autowired private LocationService locationService;

    @GetMapping("/vehicles")
    public String goVehicles(Model model) {


        model.addAttribute("vehicles",vehicleService.getVehicles());;

        model.addAttribute("vehicleHires", vehicleHireService.getVehicleHire());

        model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMake());
        model.addAttribute("vehicleModels", vehicleModelService.getVehicleModel());
        model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleType());
        model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatus());
        model.addAttribute("employees", employeeService.getEmployee());
        model.addAttribute("locations", locationService.getLocation());
        return "vehicle";

    }

    @PostMapping("/vehicles/addNew")
    public String saveVehicles(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping("vehicles/findById")
    @ResponseBody
    public Optional<Vehicle> findById(int id) {
        return vehicleService.findById(id);
    }

    @RequestMapping(value = "vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }
    @RequestMapping(value = "vehicles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleService.delete(id);
        return "redirect:/vehicles";
    }
}
