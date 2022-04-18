package com.dia.app_boot_secure.controller;

import com.dia.app_boot_secure.model.Country;
import com.dia.app_boot_secure.model.JobTitle;
import com.dia.app_boot_secure.model.State;
import com.dia.app_boot_secure.service.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {
    @Autowired
    private JobTitleService jobTitleService;

    // Get All State
    @GetMapping("/jobTitles")
    public String goStates(Model model) {
        /*
        List<State> listState = stateService.getStates();
        model.addAttribute("states", listState);

        List<Country> listCountry = countryService.getCountries();
        model.addAttribute("countries", listCountry);
        */
        List<JobTitle> listJobTitle=jobTitleService.getJobTitle();
        model.addAttribute("jobTitles",listJobTitle);
        return "jobTitle";
        //}
    }

    @PostMapping("/jobTitles/addNew")
    public String saveJobTitle(JobTitle JobTitle) {
        jobTitleService.save(JobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping("jobTitles/findById")
    @ResponseBody
    public Optional<JobTitle> findById(int id) {
        return jobTitleService.findById(id);
    }

    @RequestMapping(value = "jobTitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobTitle jobTitle) {
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping(value = "jobTitles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        jobTitleService.delete(id);
        return "redirect:/jobTitles";
    }
}
