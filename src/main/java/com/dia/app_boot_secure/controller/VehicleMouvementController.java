package com.dia.app_boot_secure.controller;

import com.dia.app_boot_secure.model.VehicleMouvement;
import com.dia.app_boot_secure.service.LocationService;
import com.dia.app_boot_secure.service.SupplierService;
import com.dia.app_boot_secure.service.VehicleMouvementService;
import com.dia.app_boot_secure.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMouvementController {
    @Autowired
    private VehicleMouvementService vehicleMouvementService;
    @Autowired private VehicleService vehicleService;
    @Autowired private LocationService locationService;

    @GetMapping("/vehicleMovements")
    public String goVehicleMouvements(Model model) {
        model.addAttribute("vehicleMouvements",vehicleMouvementService.getVehicleMouvements());;

        model.addAttribute("vehicles", vehicleService.getVehicles());

        model.addAttribute("suppliers",locationService.getLocation());

        return "vehicleMouvement";
        //}
    }

    @PostMapping("/vehicleMovements/addNew")
    public String saveVehicleMouvements(VehicleMouvement vehicleMouvement) {
        vehicleMouvementService.save(vehicleMouvement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping("vehicleMovements/findById")
    @ResponseBody
    public Optional<VehicleMouvement> findById(int id) {
        return vehicleMouvementService.findById(id);
    }

    @RequestMapping(value = "vehicleMovements/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMouvement vehicleMouvement) {
        vehicleMouvementService.save(vehicleMouvement);
        return "redirect:/vehicleMovements";
    }
    @RequestMapping(value = "vehicleMovements/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMouvementService.delete(id);
        return "redirect:/vehicleMovements";
    }
}
