package com.dia.app_boot_secure.controller;

import com.dia.app_boot_secure.model.Country;
import com.dia.app_boot_secure.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CountryController {
   // public class ApplicationController {
    @Autowired
    private CountryService countryService;
        @GetMapping("/countries")
        public String goCountries(Model model){
            List<Country> listCountries=countryService.getCountries();
            model.addAttribute("countries",listCountries);
            return "country";
        //}
    }
    @PostMapping("/countries/addNew")
    public String saveCountries(Country country){
            countryService.save(country);
            return "redirect:/countries";
    }
}
