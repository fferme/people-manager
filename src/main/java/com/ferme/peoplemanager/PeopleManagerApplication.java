package com.ferme.peoplemanager;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ferme.peoplemanager.model.Person;
import com.ferme.peoplemanager.repository.PersonRepository;

@SpringBootApplication
public class PeopleManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleManagerApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(PersonRepository personRepository) {
		return args -> {
			personRepository.deleteAll();

			Person p1 = new Person();
			p1.setName("Roberto Silva Frota");
			p1.setBirthDate(LocalDate.parse("1987-12-19"));

			personRepository.save(p1);

			Person p2 = new Person();
			p2.setName("Carla Aguiar Silva");
			p2.setBirthDate(LocalDate.parse("1980-11-02"));

			personRepository.save(p2);

			Person p3 = new Person();
			p3.setName("Jorge da Silva Mourão");
			p3.setBirthDate(LocalDate.parse("2005-11-10"));

			personRepository.save(p3);
		};
	}

}
