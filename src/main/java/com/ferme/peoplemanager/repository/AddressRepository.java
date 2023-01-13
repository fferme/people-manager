package com.ferme.peoplemanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferme.peoplemanager.model.Address;
import com.ferme.peoplemanager.model.Person;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByPerson(Person person);
}
