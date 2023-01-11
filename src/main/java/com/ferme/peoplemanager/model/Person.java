package com.ferme.peoplemanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.sql.Date;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id = UUID.randomUUID(); 

    @NotBlank
    @Length(max = 40)
    @Column(length = 40, nullable = false)
    private String name;

    @NotBlank
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(length = 10, nullable = false)
    private Date birthDate;
}
