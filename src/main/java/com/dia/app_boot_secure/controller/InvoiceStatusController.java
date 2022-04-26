package com.dia.app_boot_secure.controller;

import com.dia.app_boot_secure.model.Country;
import com.dia.app_boot_secure.model.InvoiceStatus;
import com.dia.app_boot_secure.model.State;
import com.dia.app_boot_secure.service.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {
    @Autowired
    private InvoiceStatusService invoiceStatusService;

    // Get All State
    @GetMapping("/invoiceStatuses")
    public String goStates(Model model) {
        /*List<State> listState = stateService.getStates();
        model.addAttribute("states", listState);

        List<Country> listCountry = countryService.getCountries();
        model.addAttribute("countries", listCountry);*/

        List<InvoiceStatus> listInvoiceStatus=invoiceStatusService.getInvoiceStatus();
        model.addAttribute("invoiceStatuses",listInvoiceStatus);

        return "invoiceStatus";
        //}
    }

    @PostMapping("/invoiceStatuses/addNew")
    public String saveInvoiceStatus(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatuses";
    }

    @RequestMapping("invoiceStatuses/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findById(int id) {
        return invoiceStatusService.findById(id);
    }

    @RequestMapping(value = "invoiceStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(InvoiceStatus InvoiceStatus) {
        invoiceStatusService.save(InvoiceStatus);
        return "redirect:/invoiceStatuses";
    }

    @RequestMapping(value = "invoiceStatuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        invoiceStatusService.delete(id);
        return "redirect:/invoiceStatuses";
    }
}
