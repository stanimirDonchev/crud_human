/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stanimir.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author stanimir
 */
@Data
@Entity
@Table(name = "UserDetails")
public class User {
    
    @Id
    @NotEmpty
    @Column(name = "username")
    private String username;
    
    @NotNull
    @NotEmpty
    @Column(name = "password")
    private String password;
}
