package com.dia.app_boot_secure.controller;

import com.dia.app_boot_secure.model.VehicleHire;
import com.dia.app_boot_secure.service.ClientService;
import com.dia.app_boot_secure.service.LocationService;
import com.dia.app_boot_secure.service.VehicleHireService;
import com.dia.app_boot_secure.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleHireController {
    @Autowired private VehicleHireService vehicleHireService;

    @Autowired private VehicleService vehicleService;

    @Autowired private LocationService locationService;

    @Autowired private ClientService clientService;


    @GetMapping("/vehicleHires")
    public String goStates(Model model) {

        model.addAttribute("vehicleHires",vehicleHireService.getVehicleHire());
        model.addAttribute("vehicles",vehicleService.getVehicles());
        model.addAttribute("locations",locationService.getLocation());
        model.addAttribute("clients",clientService.getClients());
        
        return "vehicleHire";
    }
    @PostMapping("/vehicleHires/addNew")
    public String saveVehicleHire(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping("vehicleHires/findById")
    @ResponseBody
    public Optional<VehicleHire> findById(int id) {
        return vehicleHireService.findById(id);
    }

    @RequestMapping(value = "vehicleHires/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping(value = "vehicleHires/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleHireService.delete(id);
        return "redirect:/vehicleHires";
    }
}
