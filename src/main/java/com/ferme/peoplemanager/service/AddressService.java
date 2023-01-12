package com.ferme.peoplemanager.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.ferme.peoplemanager.model.Address;
import com.ferme.peoplemanager.repository.AddressRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> listAll() {
        return addressRepository.findAll();
    }

    public Optional<Address> findById(@PathVariable @NotNull Long id) {
        return addressRepository.findById(id);
    }

    public Address create(@Valid Address address) {
        return addressRepository.save(address);
    }

    public List<Address> getAddressesByPersonId(Long personId) {
        return addressRepository.findByPersonId(personId);
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
