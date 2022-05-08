package com.dia.app_boot_secure.service;

import com.dia.app_boot_secure.Repository.VehicleMouvementRepository;
import com.dia.app_boot_secure.model.VehicleMouvement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMouvementService {
    @Autowired
    private VehicleMouvementRepository vehicleMouvementRepository;

    public List<VehicleMouvement> getVehicleMouvements(){
        return vehicleMouvementRepository.findAll();
    }


    public void save(VehicleMouvement vehicleMouvement){
        vehicleMouvementRepository.save(vehicleMouvement);
    }
    public Optional<VehicleMouvement> findById(int id){
        return vehicleMouvementRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleMouvementRepository.deleteById(id);
    }

}
