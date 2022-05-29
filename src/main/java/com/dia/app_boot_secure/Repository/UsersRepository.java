package com.dia.app_boot_secure.Repository;


import com.dia.app_boot_secure.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
