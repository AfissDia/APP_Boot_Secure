package com.dia.app_boot_secure.Repository;

import com.dia.app_boot_secure.model.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType,Integer> {
}
