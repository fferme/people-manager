package com.ferme.peoplemanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.Set;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Length(max = 40)
    @Column(length = 40, nullable = false)
    private String name;

    @Past
    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "person")
    private Set<Address> adresses;
}
