package com.dia.app_boot_secure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceTypeController {
    @GetMapping("/invoiceTypes")
    public String goInvoice() {
        return "invoiceType";
    }
}
