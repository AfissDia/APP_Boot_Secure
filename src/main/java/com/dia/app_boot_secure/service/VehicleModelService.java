package com.dia.app_boot_secure.service;

import com.dia.app_boot_secure.Repository.VehicleModelRepository;
import com.dia.app_boot_secure.model.VehicleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {
    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    public List<VehicleModel> getVehicleModel(){
        return vehicleModelRepository.findAll();
    }

    public void save(VehicleModel vehicleModel){
        vehicleModelRepository.save(vehicleModel);
    }
    public Optional<VehicleModel> findById(int id){
        return vehicleModelRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleModelRepository.deleteById(id);
    }
}
