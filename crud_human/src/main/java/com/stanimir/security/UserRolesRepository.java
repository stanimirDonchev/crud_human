/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stanimir.security;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author stanimir
 */
@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Long>{
    
    List<UserRoles> findByUsername(String username);
    
}
