package com.ferme.peoplemanager;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ferme.peoplemanager.model.Address;
import com.ferme.peoplemanager.model.Person;
import com.ferme.peoplemanager.repository.AddressRepository;
import com.ferme.peoplemanager.repository.PersonRepository;

@SpringBootApplication
public class PeopleManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleManagerApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(PersonRepository personRepository, AddressRepository addressRepository) {
		return args -> {
			personRepository.deleteAll();

			Person p1 = new Person("Roberto Silva Frota", LocalDate.parse("1987-12-19"));
			Person p2 = new Person("Carla Aguiar Silva", LocalDate.parse("1980-11-02"));
			Person p3 = new Person("Jorge da Silva Mourão", LocalDate.parse("2005-11-10"));

			Address a1 = new Address(null, "Rua Aquidabã", "20182000", 200, "Rio de Janeiro", true, p1);
			Address a2 = new Address(null, "Rua Silva Freire", "20182111", 15000, "Bahia", false, p1);

			personRepository.saveAll(Arrays.asList(p1, p2, p3));
			addressRepository.saveAll(Arrays.asList(a1, a2));
		};
	}

}
