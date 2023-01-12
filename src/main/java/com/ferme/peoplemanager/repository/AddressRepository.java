package com.ferme.peoplemanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferme.peoplemanager.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByPersonId(Long personId);
}
