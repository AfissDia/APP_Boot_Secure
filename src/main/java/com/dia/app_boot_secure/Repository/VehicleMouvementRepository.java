package com.dia.app_boot_secure.Repository;


//import org.springframework.data.jpa.repository.JpaRepository;
import com.dia.app_boot_secure.model.VehicleMouvement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface VehicleMouvementRepository extends JpaRepository<VehicleMouvement,Integer> {
}
