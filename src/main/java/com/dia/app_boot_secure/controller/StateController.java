package com.dia.app_boot_secure.controller;

import com.dia.app_boot_secure.Repository.CountryRepository;
import com.dia.app_boot_secure.model.Country;
import com.dia.app_boot_secure.model.State;

import com.dia.app_boot_secure.service.CountryService;
import com.dia.app_boot_secure.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StateController {
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    // Get All State
    @GetMapping("/states")
    public String goStates(Model model) {
        List<State> listState = stateService.getStates();
        model.addAttribute("states", listState);

        List<Country> listCountry = countryService.getCountries();
        model.addAttribute("countries", listCountry);

        return "state";
        //}
    }

    @PostMapping("/states/addNew")
    public String savestates(State state) {
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping("states/findById")
    @ResponseBody
    public Optional<State> findById(int id) {
        return stateService.findById(id);
    }

    @RequestMapping(value = "states/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(State state) {
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping(value = "states/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        stateService.delete(id);
        return "redirect:/states";
    }
}
