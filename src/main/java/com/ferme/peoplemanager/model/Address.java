package com.ferme.peoplemanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Length(max = 25)
    @Column(length = 25, nullable = false)
    private String street;
    
    @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$|^[0-9]{8}$")
    @Length(max = 9)
    @Column(length = 9, nullable = false)
    private String zipCode;

    @Positive
    @Column(nullable = false)
    private Integer number;

    @Length(max = 25)
    @Column(length = 25, nullable = false)
    private String city;

    @NotNull
    private Boolean principal;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
