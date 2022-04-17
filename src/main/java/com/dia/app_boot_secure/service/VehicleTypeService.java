package com.dia.app_boot_secure.service;

import com.dia.app_boot_secure.Repository.VehicleTypeRepository;
import com.dia.app_boot_secure.model.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> getVehicleType(){
        return vehicleTypeRepository.findAll();
    }

    public void save(VehicleType vehicleType){
        vehicleTypeRepository.save(vehicleType);
    }
    public Optional<VehicleType> findById(int id){
        return vehicleTypeRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleTypeRepository.deleteById(id);
    }
}
