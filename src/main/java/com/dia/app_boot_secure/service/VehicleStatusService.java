package com.dia.app_boot_secure.service;

import com.dia.app_boot_secure.Repository.VehicleStatusRepository;
import com.dia.app_boot_secure.model.VehicleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {
    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    public List<VehicleStatus> getVehicleStatus(){
        return vehicleStatusRepository.findAll();
    }

    public void save(VehicleStatus vehicleStatus){
        vehicleStatusRepository.save(vehicleStatus);
    }
    public Optional<VehicleStatus> findById(int id){
        return vehicleStatusRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }
}
