/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stanimir.service;

import com.stanimir.model.Human;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stanimir.repository.HumanJpaRepository;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stanimir
 */
@Service("embedDB")
public class HumanServiceImpl implements HumanService {
    
    @Autowired
    private HumanJpaRepository humanRepository;
    
    @Override
    public Collection<Human> getAllHumans()
    {
        return humanRepository.findAll();
    }
    
    @Override
    public void insertHuman(Human human){
        humanRepository.save(human);
    }
    
    @Override
    public Human getHumanById(Long id){
        return humanRepository.findOne(id);
    }
    
    @Override
    public void removeHumanById(Long id){
        humanRepository.delete(id);
    }
    
    @Override
    public Collection<Human> sortByLastName() {
        return humanRepository.sortByLastName();
    }
    
    @Override
    public Collection<Human> sortByDateOfBirth() {
        return humanRepository.sortByDateOfBirth();
    }
    
    @Override
    public Collection<Human> findHumansBy(String value) {
        List<Human> found = new ArrayList<>();
        found.addAll(humanRepository.searchByString(value));
      
//        DateFormat df = new SimpleDateFormat("YYYY/MM/DD");
//        try 
//        {
//            Date valueDate  = (Date)df.parse(value);
//            found.addAll(humanRepository.findByDateOfBirth(valueDate));
//        } 
//        catch (ParseException ex) 
//        {
//            //Logger.getLogger(HumanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        try
//        {
//            Long longValue = Long.parseLong(value);
//            found.add(humanRepository.findOne(longValue));
//        }
//        catch (NumberFormatException ex) 
//        {
//            //Logger.getLogger(HumanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        return found;
    }
    
    @Override
    public Human updateHuman(Human human)
    {
        Human tempHuman = humanRepository.findOne(human.getId());
        if(tempHuman != null){
            tempHuman.setFirstName(human.getFirstName());
            tempHuman.setLastName(human.getLastName());
            tempHuman.setDateOfBirth(human.getDateOfBirth());
            tempHuman.setPhoneNumber(human.getPhoneNumber());
            tempHuman.setEmail(human.getEmail());
            return humanRepository.save(human);
        }
        return null;
    }
    
}
