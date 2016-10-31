/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stanimir.repository;

import com.stanimir.model.Human;
import java.sql.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author stanimir
 */
@Repository
public interface HumanJpaRepository extends JpaRepository<Human, Long> {

//    @Query("select u from Human u order by lastName")
//    List<Human> sortByLastName();
//
//    @Query("select u from Human u order by dateOfBirth")
//    List<Human> sortByDateOfBirth();
    @Query("select u from Human u where upper(u.firstName) like upper(concat('%', ?1, '%')) or "
            + "upper(u.lastName) like upper(concat('%', ?1, '%')) or "
            + "upper(u.phoneNumber) like upper(concat('%', ?1, '%')) or "
            + "upper(u.email) like upper(concat('%', ?1, '%'))")
    List<Human> searchByString(String value);

    List<Human> findByDateOfBirth(Date date);

    @Override
    Page<Human> findAll(Pageable pageable);

    @Override
    List<Human> findAll(Sort sort);

    Long countByLastNameIgnoreCase(String lastName);

    List<Human> findByLastNameIgnoreCaseOrderByFirstNameAsc(String lastName);
}
