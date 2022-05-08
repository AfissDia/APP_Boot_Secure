package com.dia.app_boot_secure.controller;

import com.dia.app_boot_secure.model.Country;
import com.dia.app_boot_secure.model.Client;
import com.dia.app_boot_secure.model.State;
import com.dia.app_boot_secure.service.CountryService;
import com.dia.app_boot_secure.service.ClientService;
import com.dia.app_boot_secure.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {
    @Autowired private ClientService clientService;
    @Autowired private CountryService countryService;
    @Autowired private StateService stateService;

    @GetMapping("/clients")
    public String goClients(Model model) {
        model.addAttribute("clients",clientService.getClients());;

        model.addAttribute("countries", countryService.getCountries());

        model.addAttribute("states", stateService.getStates());

        return "client";

    }

    @PostMapping("/clients/addNew")
    public String saveClients(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping("clients/findById")
    @ResponseBody
    public Optional<Client> findById(int id) {
        return clientService.findById(id);
    }

    @RequestMapping(value = "clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }
    @RequestMapping(value = "clients/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        clientService.delete(id);
        return "redirect:/clients";
    }
}
