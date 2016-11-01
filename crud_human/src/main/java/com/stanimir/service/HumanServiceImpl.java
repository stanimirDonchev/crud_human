/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stanimir.service;

import com.stanimir.model.Human;
import com.stanimir.repository.HumanJpaRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author stanimir
 */
@Service("embedDB")
public class HumanServiceImpl implements HumanService {

    @Autowired
    private HumanJpaRepository humanRepository;

    @Override
    public Collection<Human> getAllHumans() {
        return humanRepository.findAll();
    }

    @Override
    public void insertHuman(Human human) {
        humanRepository.save(human);
    }

    @Override
    public Human getHumanById(Long id) {
        return humanRepository.findOne(id);
    }

    @Override
    public void removeHumanById(Long id) {
        humanRepository.delete(id);
    }

//    @Override
//    public Collection<Human> sortByLastName() {
//        return humanRepository.sortByLastName();
//    }
//
//    @Override
//    public Collection<Human> sortByDateOfBirth() {
//        return humanRepository.sortByDateOfBirth();
//    }
    @Override
    public Collection<Human> findHumansBy(String value) {
        List<Human> found = new ArrayList<>();
        found.addAll(humanRepository.searchByString(value));
        return found;
    }

    @Override
    public Human updateHuman(Human human) {
        Human tempHuman = humanRepository.findOne(human.getId());
        if (tempHuman != null) {
            tempHuman.setFirstName(human.getFirstName());
            tempHuman.setLastName(human.getLastName());
            tempHuman.setDateOfBirth(human.getDateOfBirth());
            tempHuman.setPhoneNumber(human.getPhoneNumber());
            tempHuman.setEmail(human.getEmail());
            return humanRepository.save(human);
        }
        return null;
    }

    @Override
    public Page<Human> getAllHumansPaged(Pageable pageable) {
        return humanRepository.findAll(pageable);
    }

    @Override
    public Collection<Human> sortHumansBy(Sort sort) {
        return humanRepository.findAll(sort);
    }

    @Override
    public Long getHumanCount() {
        return humanRepository.count();
    }

    @Override
    public Long getHumanCountByLastName(String lastName) {
        return humanRepository.countByLastNameIgnoreCase(lastName);
    }

    @Override
    public Collection<Human> getHumansByLastNameOrderByFisrtNameAsc(String lastName) {
        return humanRepository.findByLastNameIgnoreCaseOrderByFirstNameAsc(lastName);
    }

    @Override
    public Collection<Human> search(String value) {
        return humanRepository.findByIdContainingOrFirstNameContainingOrLastNameContainingOrPhoneNumberContainingOrEmailContainingOrDateOfBirthContainingAllIgnoreCase(value, value, value, value, value, value);
    }
}
