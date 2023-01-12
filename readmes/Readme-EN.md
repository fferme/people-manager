# People Manager

People Manager is a people management application developed using Spring Boot. It allows creating, editing, querying and listing people, as well as creating, listing and managing addresses of those people.

## Notes

- The annotation `@Lombok` is being used to generated automatically `getters, setters, constructors, hash code and equals.`

# Tests

All integrated tests are located in: [Test-Evidences](https://github.com/fferme/people-manager/blob/master/src/test/java/com/ferme/peoplemanager/test-evidences/Test-Evidences.md)

## Features

- Create a person
- Edit a person
- Query a person
- List people
- Create address for person
- List addresses of person
- Be able to specify which address is the person's main address

## Technologies

- Spring Boot
- Java Bean Validation
- Spring Data JPA
- H2 Database

## How to run the project

1. Clone the repository: git clone https://github.com/fferme/people-manager.git
2. Go into the project folder: cd people-manager
3. Run the command mvn spring-boot:run
4. Acess [http://localhost:8080/h2-console](http://localhost:8080/h2-console) in your browser to see data displayed in tables
5. Use Imsomnia ou any other REST program to make HTTP requests

## Testing the API

The API routes can be tested using tools like Postman. The available routes include:

- GET `/person`: lists all registered person
- GET `/person/{id}`: queries a person by their ID
- POST `/person`: creates a new person
- PUT `/person/{id}`: updates an existing person
- DELETE `/person/{id}`: removes an existing person
- GET `/person/{id}/addresses`: lists all addresses of a person
- POST `/person/{id}/addresses`: creates a new address for a person
- PUT `/person/{id}/addresses/{addressId}`: updates an existing address of a person
- DELETE `/person/{id}/addresses/{addressId}`: removes an existing address of a person
- PUT `/person/{id}/addresses/{addressId}/main`: sets an address as the main address of a person

## Unit Tests

Unit tests can be run using the command mvn test at the root of the project.

## Notes

This project was developed as an example and can be used as a base for similar projects. It can still be improved and refined according to the specific needs of the project.
