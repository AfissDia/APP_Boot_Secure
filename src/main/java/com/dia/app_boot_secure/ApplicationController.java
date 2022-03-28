package com.dia.app_boot_secure;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    @GetMapping("/index")
    public String goHome(){
        return "index";
    }
}
