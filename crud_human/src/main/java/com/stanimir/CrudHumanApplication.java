package com.stanimir;

import com.stanimir.security.User;
import com.stanimir.security.UserRepository;
import com.stanimir.security.UserRoles;
import com.stanimir.security.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.web.csrf.CsrfToken;

@SpringBootApplication
public class CrudHumanApplication{

    public static void main(String[] args) {
            SpringApplication.run(CrudHumanApplication.class, args);
    }
}
