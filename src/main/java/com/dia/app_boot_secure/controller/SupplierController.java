package com.dia.app_boot_secure.controller;

import com.dia.app_boot_secure.model.Supplier;
import com.dia.app_boot_secure.service.SupplierService;
import com.dia.app_boot_secure.service.CountryService;
import com.dia.app_boot_secure.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @Autowired private CountryService countryService;
    @Autowired private StateService stateService;

    @GetMapping("/suppliers")
    public String goSuppliers(Model model) {
        model.addAttribute("suppliers",supplierService.getSuppliers());;

        model.addAttribute("countries", countryService.getCountries());

        model.addAttribute("states", stateService.getStates());

        return "supplier";
        //}
    }

    @PostMapping("/suppliers/addNew")
    public String saveSuppliers(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping("suppliers/findById")
    @ResponseBody
    public Optional<Supplier> findById(int id) {
        return supplierService.findById(id);
    }

    @RequestMapping(value = "suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }
    @RequestMapping(value = "suppliers/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        supplierService.delete(id);
        return "redirect:/suppliers";
    }
}
