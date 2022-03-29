package com.dia.app_boot_secure.repository;

import com.dia.app_boot_secure.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Client,Integer> {
}
