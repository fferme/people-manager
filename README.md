# Gerenciador de Pessoas

Gerenciador de pessoas é uma aplicação de gerenciamento de pessoas desenvolvida usando Spring Boot. Ele permite a criação, edição, consulta e listagem de pessoas, bem como a criação, listagem e gerenciamento de endereços dessas pessoas. A API está sendo hospedada na AWS. 

## Notas

* A anotação `@Lombok` está sendo usada para gerar automaticamente `getters, setters, construtores (exceto class Person), hash code e equals`.

## Testando a API

As rotas da API podem ser testadas usando ferramentas como o Postman. As rotas disponíveis incluem:

* GET `http://people-manager.sa-east-1.elasticbeanstalk.com/api/person`: lista todas as pessoas registradas ✔️
* GET `http://people-manager.sa-east-1.elasticbeanstalk.com/api/person/{id}`: consulta uma pessoa pelo seu ID ✔️
* POST `http://people-manager.sa-east-1.elasticbeanstalk.com/api/person`: cria uma nova pessoa ✔️
* PUT `http://people-manager.sa-east-1.elasticbeanstalk.com/api/person/{id}`: atualiza uma pessoa existente ✔️
* DELETE `http://people-manager.sa-east-1.elasticbeanstalk.com/api/person/{id}`: remove uma pessoa existente ✔️
* GET `http://people-manager.sa-east-1.elasticbeanstalk.com/api/person/{id}/addresses`: lista todos os endereços de uma pessoa ✔️
* GET `http://people-manager.sa-east-1.elasticbeanstalk.com/api/person/{id}/addresses/principal`: recupera o endereço principal de uma pessoa ✔️
* POST `http://people-manager.sa-east-1.elasticbeanstalk.com/api/person/{id}/addresses`: cria um novo endereço para uma pessoa ✔️
* PUT `http://people-manager.sa-east-1.elasticbeanstalk.com/api/person/{id}/addresses/{addressId}`: atualiza um endereço existente de uma pessoa
* DELETE `http://people-manager.sa-east-1.elasticbeanstalk.com/api/person/{id}/addresses/{addressId}`: remove um endereço existente de uma pessoa
* PUT `http://people-manager.sa-east-1.elasticbeanstalk.com/api/person/{id}/addresses/{addressId}/main`: define um endereço como o endereço principal de uma pessoa

PS: Rotas sem ✔️ ainda não foram implementadas

# Testes

Todos os testes integrados estão localizados em: [Evidencias-de-teste](docs/test-evidences/evidencias-de-teste.md)

## Recursos

* Editar uma pessoa
* Consultar uma pessoa
* Listar pessoas
* Criar endereço para pessoa
* Listar endereços de pessoa
* Recuperar endereço principal de pessoa
* Ser capaz de especificar qual é o endereço principal da pessoa

## Tecnologias

* Spring Boot
* Elastic Beanstick - AWS
* Java Bean Validation
* Spring Data JPA
* Banco de dados H2

## Testes Unitários

Os testes unitários podem ser executados usando o comando mvn test na raiz do projeto.

## Notas

Este projeto foi desenvolvido como um exemplo e pode ser usado como base para projetos semelhantes. Ele ainda pode ser melhorado e refinado de acordo com as necessidades específicas do projeto.
