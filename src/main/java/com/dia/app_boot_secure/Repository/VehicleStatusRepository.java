package com.dia.app_boot_secure.Repository;

import com.dia.app_boot_secure.model.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleStatusRepository extends JpaRepository<VehicleStatus,Integer> {
}
