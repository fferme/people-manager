package com.ferme.peoplemanager.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferme.peoplemanager.model.Person;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    
}
