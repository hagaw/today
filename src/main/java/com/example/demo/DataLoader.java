package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;

@Component

public class DataLoader implements CommandLineRunner{
    @Autowired
    UserRepository userReopsitory;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String...strings)throws Exception{
         roleRepository.save(new Role("USER"));
         roleRepository.save(new Role("ADMIN"));

         Role adminRole=roleRepository.findByRole("ADMIN");
         Role userRole=roleRepository.findByRole("USER");

         User user=new User("jim@jim.com", "password","Jim","Jimmerson",true,"jim");

         user.setRoles(Arrays.asList(userRole));
         userReopsitory.save(user);

         user=new User("admin@admin.com","password","admin","User",true,"admin");

          user.setRoles(Arrays.asList(adminRole));
          userReopsitory.save(user);
    }

}

