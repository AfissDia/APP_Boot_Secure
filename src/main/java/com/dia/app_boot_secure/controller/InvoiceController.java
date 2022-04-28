package com.dia.app_boot_secure.controller;

import com.dia.app_boot_secure.model.Client;
import com.dia.app_boot_secure.model.Country;
import com.dia.app_boot_secure.model.Invoice;
import com.dia.app_boot_secure.model.InvoiceStatus;
import com.dia.app_boot_secure.service.ClientService;
import com.dia.app_boot_secure.service.CountryService;
import com.dia.app_boot_secure.service.InvoiceService;
import com.dia.app_boot_secure.service.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private InvoiceStatusService invoiceStatusService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/invoices")
    public String goInvoices(Model model) {
        List<Invoice> listInvoice = invoiceService.getInvoices();
        model.addAttribute("invoices", listInvoice);

        model.addAttribute("invoiceStatuses", invoiceStatusService.getInvoiceStatus());

        List<Client> listClient = clientService.getClients();
        model.addAttribute("clients", listClient);
        return "invoice";
    }

    @PostMapping("/invoices/addNew")
    public String saveInvoices(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping("invoices/findById")
    @ResponseBody
    public Optional<Invoice> findById(int id) {
        return invoiceService.findById(id);
    }

    @RequestMapping(value = "invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value = "invoices/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        invoiceService.delete(id);
        return "redirect:/invoices";
    }
}
