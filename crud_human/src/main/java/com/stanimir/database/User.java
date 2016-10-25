/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stanimir.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author stanimir
 */
@Data
@Entity
@Table(name = "User")
public class User {
    
    @Id
    @NotNull
    private String username;
    
    @NotNull
    private String password;
}
