package com.stanimir;

import com.stanimir.database.User;
import com.stanimir.database.UserRepository;
import com.stanimir.database.UserRoles;
import com.stanimir.database.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.web.csrf.CsrfToken;

@SpringBootApplication
public class CrudHumanApplication implements CommandLineRunner{
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserRolesRepository userRolesRepository;
    

    public static void main(String[] args) {
            SpringApplication.run(CrudHumanApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        User user = new User();
        user.setUsername("pesho");
        user.setPassword("pesho");
        userRepository.save(user);
        
        UserRoles userRole = new UserRoles();
        userRole.setUserId(1L);
        userRole.setRole("ADMIN");
        userRolesRepository.save(userRole);
    }
}
