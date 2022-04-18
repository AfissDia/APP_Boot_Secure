package com.dia.app_boot_secure.controller;

import com.dia.app_boot_secure.model.Country;
import com.dia.app_boot_secure.model.VehicleModel;
import com.dia.app_boot_secure.model.State;
import com.dia.app_boot_secure.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {
    @Autowired
    private VehicleModelService vehicleModelService;

    // Get All State
    @GetMapping("/vehicleModels")
    public String goStates(Model model) {
        /*List<State> listState = stateService.getStates();
        model.addAttribute("states", listState);

        List<Country> listCountry = countryService.getCountries();
        model.addAttribute("countries", listCountry);*/

        List<VehicleModel> listVehicleModel=vehicleModelService.getVehicleModel();
        model.addAttribute("vehicleModels",listVehicleModel);

        return "vehicleModel";
        //}
    }

    @PostMapping("/vehicleModels/addNew")
    public String saveVehicleModel(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModels";
    }

    @RequestMapping("vehicleModels/findById")
    @ResponseBody
    public Optional<VehicleModel> findById(int id) {
        return vehicleModelService.findById(id);
    }

    @RequestMapping(value = "vehicleModels/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModels";
    }

    @RequestMapping(value = "vehicleModels/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleModelService.delete(id);
        return "redirect:/vehicleModels";
    }
}
