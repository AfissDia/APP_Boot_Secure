package com.dia.app_boot_secure.controller;

import com.dia.app_boot_secure.model.Contact;
import com.dia.app_boot_secure.service.ContactService;
import com.dia.app_boot_secure.service.CountryService;
import com.dia.app_boot_secure.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;
    @Autowired private CountryService countryService;
    @Autowired private StateService stateService;

    @GetMapping("/contacts")
    public String goContacts(Model model) {
        model.addAttribute("contacts",contactService.getContacts());;

        model.addAttribute("countries", countryService.getCountries());

        model.addAttribute("states", stateService.getStates());

        return "contact";
    }

    @PostMapping("/contacts/addNew")
    public String saveContacts(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping("contacts/findById")
    @ResponseBody
    public Optional<Contact> findById(int id) {
        return contactService.findById(id);
    }

    @RequestMapping(value = "contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }
    @RequestMapping(value = "contacts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        contactService.delete(id);
        return "redirect:/contacts";
    }
}
