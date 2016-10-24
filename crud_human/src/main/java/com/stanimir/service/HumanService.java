/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stanimir.service;

import com.stanimir.model.Human;
import java.util.Collection;

/**
 *
 * @author stanimir
 */
public interface HumanService {

    Collection<Human> findHumansBy(String value);

    Collection<Human> getAllHumans();

    Human getHumanById(Long id);

    void insertHuman(Human human);

    void removeHumanById(Long id);

    Collection<Human> sortByDateOfBirth();

    Collection<Human> sortByLastName();

    Human updateHuman(Human human);
    
}
