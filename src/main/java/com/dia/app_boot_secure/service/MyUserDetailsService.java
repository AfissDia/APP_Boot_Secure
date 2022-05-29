package com.dia.app_boot_secure.service;

//import com.dia.app_boot_secure.Repository.UserRepository;
import com.dia.app_boot_secure.Repository.UsersRepository;
import com.dia.app_boot_secure.model.User;
//import com.dia.app_boot_secure.model.UserPrincipal;
import com.dia.app_boot_secure.model.Users;
import com.dia.app_boot_secure.model.UsersPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import java.nio.file.attribute.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService {
 @Autowired UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Users users = usersRepository.findByUsername(username);
    if (users == null){
        throw new UsernameNotFoundException("User not fond");
    }
    return new UsersPrincipal(users);
    }
}
