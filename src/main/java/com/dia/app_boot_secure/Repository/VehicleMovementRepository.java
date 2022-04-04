package com.dia.app_boot_secure.Repository;

import com.dia.app_boot_secure.model.VehicleMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMovementRepository extends JpaRepository<VehicleMovement,Integer> {
}
