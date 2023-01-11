package com.ferme.peoplemanager.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

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

    public Optional<Person> findById(@PathVariable @NotNull UUID id) {
        return personRepository.findById(id);
    }

    public Person create(@Valid Person client) {
        return personRepository.save(client);
    }

    public Optional<Person> update(@NotNull UUID id, @Valid Person newPerson) {
        return personRepository.findById(id)
                .map(personFound -> {
                    personFound.setName(newPerson.getName());
                    personFound.setBirthDate(null);
                    return personRepository.save(personFound);
                });
    }

    public boolean delete(@PathVariable @NotNull UUID id) {
        return personRepository.findById(id)
            .map(recordFound -> {
                personRepository.deleteById(id);
                return true;
            })
            .orElse(false);
    }
    
}