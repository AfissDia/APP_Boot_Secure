package com.dia.app_boot_secure.service;

import com.dia.app_boot_secure.Repository.VehicleMakeRepository;
import com.dia.app_boot_secure.model.VehicleMake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    public List<VehicleMake> getVehicleMake(){
        return vehicleMakeRepository.findAll();
    }

    public void save(VehicleMake vehicleMake){
        vehicleMakeRepository.save(vehicleMake);
    }
    public Optional<VehicleMake> findById(int id){
        return vehicleMakeRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleMakeRepository.deleteById(id);
    }
}
