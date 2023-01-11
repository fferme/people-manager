package com.ferme.peoplemanager.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ferme.peoplemanager.model.Person;
import com.ferme.peoplemanager.service.PersonService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Validated
@RestController
@RequestMapping("/api/person")
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public @ResponseBody List<Person> listAll() {
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable @NotNull UUID id) {
        return personService.findById(id)
            .map(clientFound -> ResponseEntity.ok().body(clientFound))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Person create(@RequestBody @Valid Person person) {
        return personService.create(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable @NotNull UUID id, 
        @RequestBody @Valid Person newPerson) {
        return personService.update(id, newPerson)
            .map(recordFound -> ResponseEntity.ok().body(recordFound))
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (personService.delete(id)) {
            return ResponseEntity.noContent().<Void>build();
        }
        return ResponseEntity.notFound().build();
    }

}