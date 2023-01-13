package com.ferme.peoplemanager.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.ferme.peoplemanager.model.Address;
import com.ferme.peoplemanager.model.Person;
import com.ferme.peoplemanager.repository.AddressRepository;
import com.ferme.peoplemanager.repository.PersonRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;

    public AddressService(AddressRepository addressRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }

    public List<Address> listAll() {
        return addressRepository.findAll();
    }

    public List<Address> listAddressesByPerson(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        return addressRepository.findByPerson(person);
    }

    public Optional<Address> findById(@PathVariable @NotNull Long id) {
        return addressRepository.findById(id);
    }

    public Address create(@Valid Address address) {
        return addressRepository.save(address);
    }

    public Optional<Address> update(@NotNull Long id, @Valid Address newaddress) {
        return addressRepository.findById(id)
                .map(addressFound -> {
                    addressFound.setStreet(newaddress.getStreet());
                    addressFound.setZipCode(newaddress.getZipCode());
                    addressFound.setNumber(newaddress.getNumber());
                    addressFound.setCity(newaddress.getCity());
                    addressFound.setPrincipal(newaddress.getPrincipal());

                    return addressRepository.save(addressFound);
                });
    }

    public boolean delete(@PathVariable @NotNull Long id) {
        return addressRepository.findById(id)
            .map(recordFound -> {
                addressRepository.deleteById(id);
                return true;
            })
            .orElse(false);
    }
    
}
