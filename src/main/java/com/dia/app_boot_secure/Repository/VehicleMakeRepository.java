package com.dia.app_boot_secure.Repository;

import com.dia.app_boot_secure.model.VehicleMake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMakeRepository extends JpaRepository<VehicleMake,Integer> {
}
