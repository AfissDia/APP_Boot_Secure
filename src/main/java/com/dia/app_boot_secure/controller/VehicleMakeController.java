package com.dia.app_boot_secure.controller;

import com.dia.app_boot_secure.model.Country;
import com.dia.app_boot_secure.model.VehicleMake;
import com.dia.app_boot_secure.model.State;
import com.dia.app_boot_secure.service.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {
    @Autowired
    private VehicleMakeService vehicleMakeService;

    // Get All State
    @GetMapping("/vehicleMakes")
    public String goStates(Model model) {
        /*List<State> listState = stateService.getStates();
        model.addAttribute("states", listState);

        List<Country> listCountry = countryService.getCountries();
        model.addAttribute("countries", listCountry);*/

        List<VehicleMake> listVehicleMake=vehicleMakeService.getVehicleMake();
        model.addAttribute("vehicleMakes",listVehicleMake);

        return "vehicleMake";
        //}
    }

    @PostMapping("/vehicleMakes/addNew")
    public String saveVehicleMake(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMakes";
    }

    @RequestMapping("vehicleMakes/findById")
    @ResponseBody
    public Optional<VehicleMake> findById(int id) {
        return vehicleMakeService.findById(id);
    }

    @RequestMapping(value = "vehicleMakes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMakes";
    }

    @RequestMapping(value = "vehicleMakes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMakeService.delete(id);
        return "redirect:/vehicleMakes";
    }
}
