package com.ferme.peoplemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferme.peoplemanager.model.Address;
import com.ferme.peoplemanager.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
