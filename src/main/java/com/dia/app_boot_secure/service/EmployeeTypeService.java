package com.dia.app_boot_secure.service;

import com.dia.app_boot_secure.Repository.EmployeeTypeRepository;
import com.dia.app_boot_secure.model.EmployeeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    public List<EmployeeType> getEmployeeType(){
        return employeeTypeRepository.findAll();
    }

    public void save(EmployeeType employeeType){
        employeeTypeRepository.save(employeeType);
    }
    public Optional<EmployeeType> findById(int id){
        return employeeTypeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeTypeRepository.deleteById(id);
    }
}
