package com.dia.app_boot_secure.controller;

import com.dia.app_boot_secure.model.Country;
import com.dia.app_boot_secure.model.VehicleType;
import com.dia.app_boot_secure.model.State;
import com.dia.app_boot_secure.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {
    @Autowired
    private VehicleTypeService vehicleTypeService;

    // Get All State
    @GetMapping("/vehicleTypes")
    public String goStates(Model model) {
        /*List<State> listState = stateService.getStates();
        model.addAttribute("states", listState);*/

       /* List<Country> listCountry = countryService.getCountries();
        model.addAttribute("countries", listCountry);*/

        List<VehicleType> listVehicleType = vehicleTypeService.getVehicleType();
        model.addAttribute("vehicleTypes", listVehicleType);

        return "vehicleType";
        //}
    }

    @PostMapping("/vehicleTypes/addNew")
    public String saveVehicleType(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @RequestMapping("vehicleTypes/findById")
    @ResponseBody
    public Optional<VehicleType> findById(int id) {
        return vehicleTypeService.findById(id);
    }

    @RequestMapping(value = "vehicleTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @RequestMapping(value = "vehicleTypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleTypeService.delete(id);
        return "redirect:/vehicleTypes";
    }
}
