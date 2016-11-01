package com.stanimir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudHumanApplication {//implements CommandLineRunner {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserRolesRepository userRolesRepository;
    public static void main(String[] args) {
        SpringApplication.run(CrudHumanApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        User pesho = new User();
//        pesho.setUsername("pesho");
//        pesho.setPassword(new BCryptPasswordEncoder().encode("pesho"));
//        userRepository.save(pesho);
//
//        User gosho = new User();
//        gosho.setUsername("gosho");
//        gosho.setPassword(new BCryptPasswordEncoder().encode("gosho"));
//        userRepository.save(gosho);
//
//        UserRoles userRolePesho = new UserRoles();
//        userRolePesho.setUsername("pesho");
//        userRolePesho.setRole("USER");
//        userRolesRepository.save(userRolePesho);
//
//        UserRoles userRoleGosho = new UserRoles();
//        userRoleGosho.setUsername("gosho");
//        userRoleGosho.setRole("USER");
//        userRolesRepository.save(userRoleGosho);
//    }
//    @Override
//    public void run(String... args) throws Exception {
//        User pesho = new User();
//        pesho.setUsername("misho");
//        pesho.setPassword(new BCryptPasswordEncoder().encode("misho"));
//        userRepository.save(pesho);
//
//        UserRoles userRolePesho = new UserRoles();
//        userRolePesho.setUsername("misho");
//        userRolePesho.setRole("ADMIN");
//        userRolesRepository.save(userRolePesho);
//    }
}
