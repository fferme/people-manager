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
import com.ferme.peoplemanager.service.AddressService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Validated
@RestController
@RequestMapping("/api/address")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public @ResponseBody List<Address> listAll() {
        return addressService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findById(@PathVariable @NotNull Long id) {
        return addressService.findById(id)
            .map(personFound -> ResponseEntity.ok().body(personFound))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Address create(@RequestBody @Valid Address person) {
        return addressService.create(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@PathVariable @NotNull Long id, 
        @RequestBody @Valid Address newaddress) {
        return addressService.update(id, newaddress)
            .map(recordFound -> ResponseEntity.ok().body(recordFound))
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (addressService.delete(id)) {
            return ResponseEntity.noContent().<Void>build();
        }
        return ResponseEntity.notFound().build();
    }
}
