package com.dia.app_boot_secure.service;

import com.dia.app_boot_secure.Repository.VehicleRepository;
import com.dia.app_boot_secure.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }

    public void save(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }
    public Optional<Vehicle> findById(int id){
        return vehicleRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleRepository.deleteById(id);
    }
}
