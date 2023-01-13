package com.ferme.peoplemanager.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.ferme.peoplemanager.model.Address;
import com.ferme.peoplemanager.model.Person;
import com.ferme.peoplemanager.repository.PersonRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> listAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(@PathVariable @NotNull Long id) {
        return personRepository.findById(id);
    }

    public Person create(@Valid Person client) {
        return personRepository.save(client);
    }

    public Optional<Person> update(@NotNull Long id, @Valid Person newPerson) {
        return personRepository.findById(id)
                .map(personFound -> {
                    personFound.setName(newPerson.getName());
                    personFound.setBirthDate(newPerson.getBirthDate());
                    return personRepository.save(personFound);
                });
    }

    public boolean delete(@PathVariable @NotNull Long id) {
        return personRepository.findById(id)
            .map(recordFound -> {
                personRepository.deleteById(id);
                return true;
            })
            .orElse(false);
    }
    
    public Address getPrincipalAddress(@NotNull Long id) {
        Person person = personRepository.findById(id).orElse(null);
        if (person == null) {
            return null;
        }
        
        return person.getAddresses().stream()
            .filter(address -> address.getPrincipal())
            .findFirst()
            .orElse(null);
    }
    
}
