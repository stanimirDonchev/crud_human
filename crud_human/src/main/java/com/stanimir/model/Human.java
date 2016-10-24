/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stanimir.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author stanimir
 */
@Entity
@Data
@Table(name = "Human")
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @NotEmpty
    @Column(name = "firstName")
    private String firstName;
    
    @NotNull
    @NotEmpty
    @Column(name = "lastName")
    private String lastName;
    
    @Past
    @NotNull
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;
    
    @NotNull
    @NotEmpty
    @Column(name = "phoneNumber")
    private String phoneNumber;
    
    @NotNull
    @NotEmpty
    @Email
    @Column(name = "email")
    private String email;

    public Human() {
    }
    
    public Human(String firstName, String lastName, Date dateOfBirth, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    public Human(Long id, String firstName, String lastName, Date dateOfBirth, String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
