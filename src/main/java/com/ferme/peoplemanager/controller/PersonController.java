package com.ferme.peoplemanager.controller;

import java.util.List;

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

import com.ferme.peoplemanager.model.Address;
import com.ferme.peoplemanager.model.Person;
import com.ferme.peoplemanager.service.AddressService;
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
    private final AddressService addressService;

    @GetMapping
    public @ResponseBody List<Person> listAll() {
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable @NotNull Long id) {
        return personService.findById(id)
            .map(personFound -> ResponseEntity.ok().body(personFound))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Person createPerson(@RequestBody @Valid Person person) {
        return personService.create(person);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable @NotNull Long id, 
        @RequestBody @Valid Person newPerson) {
        return personService.update(id, newPerson)
            .map(recordFound -> ResponseEntity.ok().body(recordFound))
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (personService.delete(id)) {
            return ResponseEntity.noContent().<Void>build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/addresses")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Address> addAddressToPerson(@PathVariable Long id, @Valid @RequestBody Address address) {
        Person person = personService.findById(id).orElse(null);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 
        address.setPerson(person);
        Address savedAddress = addressService.create(address);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
    }

    @GetMapping("/{id}/addresses")
    public List<Address> getAddressesByPerson(@PathVariable Long id) {
        return addressService.listAddressesByPerson(id);
    }

    @GetMapping("/{id}/addresses/principal")
    public ResponseEntity<Address> getPrincipalAddress(@PathVariable Long id) {
        return new ResponseEntity<>(personService.getPrincipalAddress(id), HttpStatus.OK);
    }

}
