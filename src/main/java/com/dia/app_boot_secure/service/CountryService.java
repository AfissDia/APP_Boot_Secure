package com.dia.app_boot_secure.service;

import com.dia.app_boot_secure.Repository.CountryRepository;
import com.dia.app_boot_secure.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

   public List<Country> getCountries(){
       return countryRepository.findAll();
   }
   public void save(Country country){
       countryRepository.save(country);
   }
}
