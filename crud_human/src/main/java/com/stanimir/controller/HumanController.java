/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stanimir.controller;

import com.stanimir.model.Human;
import com.stanimir.service.HumanService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author stanimir
 */
@RestController
@RequestMapping("/humans")
public class HumanController {

    @Autowired
    @Qualifier("embedDB")
    private HumanService humanService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Human> getAllHumans() {
        return humanService.getAllHumans();

    }

    @RequestMapping(value = "/page/{number}/entries/{entryNumber}", method = RequestMethod.GET)
    public Page<Human> getAllHumansPaged(@PathVariable("number") Integer pageNumber, @PathVariable("entryNumber") Integer entryNumber) {
        return humanService.getAllHumansPaged(new PageRequest(pageNumber, entryNumber));

    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertHuman(@RequestBody Human human) {
        humanService.insertHuman(human);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Human getHumanById(@PathVariable("id") Long id) {
        return humanService.getHumanById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteHumanById(@PathVariable("id") Long id) {
        humanService.removeHumanById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Human updateHuman(@RequestBody Human human) {
        return humanService.updateHuman(human);
    }
//
//    @RequestMapping(value = "/sortByLastName", method = RequestMethod.GET)
//    public Collection<Human> sortByLastName() {
//        return humanService.sortByLastName();
//    }
//
//    @RequestMapping(value = "/sortByDateOfBirth", method = RequestMethod.GET)
//    public Collection<Human> sortByDateOfBirth() {
//        return humanService.sortByDateOfBirth();
//    }

    @RequestMapping(value = "/sortHumansBy/{param}", method = RequestMethod.GET)
    public Collection<Human> sortHumans(@PathVariable("param") String param) {
        return humanService.sortHumansBy(new Sort(param));
    }

    //TODO: fix
    @RequestMapping(value = "/find/{value}", method = RequestMethod.GET)
    public Collection<Human> find(@PathVariable String value) {
        return humanService.findHumansBy(value);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Long getHumansCount() {
        return humanService.getHumanCount();
    }

    @RequestMapping(value = "/countByLastname/{lastName}", method = RequestMethod.GET)
    public Long getHumansCountBy(@PathVariable("lastName") String lastName) {
        return humanService.getHumanCountByLastName(lastName);
    }

    @RequestMapping(value = "/findByLastNameOrderByFirstNameAsc/{lastName}", method = RequestMethod.GET)
    public Collection<Human> getHumansByLastNameOrderByFirstNameAsc(@PathVariable("lastName") String lastName) {
        return humanService.getHumansByLastNameOrderByFisrtNameAsc(lastName);
    }

    @RequestMapping(value = "/search/{value}", method = RequestMethod.GET)
    public Collection<Human> search(@PathVariable String value) {
        return humanService.search(value);
    }

}
