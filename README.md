# Gerenciador de Pessoas

Gerenciador de pessoas é uma aplicação de gerenciamento de pessoas desenvolvida usando Spring Boot. Ele permite a criação, edição, consulta e listagem de pessoas, bem como a criação, listagem e gerenciamento de endereços dessas pessoas.

## Notas

* A anotação `@Lombok` está sendo usada para gerar automaticamente `getters, setters, construtores (exceto class Person), hash code e equals`.

# Testes

Todos os testes integrados estão localizados em: [Evidencias-de-teste](docs/test-evidences/evidencias-de-teste.md)

## Recursos

* Editar uma pessoa
* Consultar uma pessoa
* Listar pessoas
* Criar endereço para pessoa
* Listar endereços de pessoa
* Ser capaz de especificar qual é o endereço principal da pessoa

## Tecnologias

* Spring Boot
* Java Bean Validation
* Spring Data JPA
* Banco de dados H2

## Como executar o projeto

1. Clone o repositório: git clone [https://github.com/fferme/people-manager.git](https://github.com/fferme/people-manager.git)
2. Vá para a pasta do projeto: cd people-manager
3. Execute o comando mvn spring-boot:run
4. Acesse [http://localhost:8080/h2-console](http://localhost:8080/h2-console) no seu navegador para acessar dados mostrados nas tabelas
5. Utilize o Imsonia ou qualquer programa REST para realizar as requisições HTTP

## Testando a API

As rotas da API podem ser testadas usando ferramentas como o Postman. As rotas disponíveis incluem:

* GET `api/person`: lista todas as pessoas registradas
* GET `api/person/{id}`: consulta uma pessoa pelo seu ID
* POST `api/person`: cria uma nova pessoa
* PUT `api/person/{id}`: atualiza uma pessoa existente
* DELETE `api/person/{id}`: remove uma pessoa existente
* GET `api/person/{id}/addresses`: lista todos os endereços de uma pessoa
* POST `api/person/{id}/addresses`: cria um novo endereço para uma pessoa
* PUT `api/person/{id}/addresses/{addressId}`: atualiza um endereço existente de uma pessoa
* DELETE `api/person/{id}/addresses/{addressId}`: remove um endereço existente de uma pessoa
* PUT `api/person/{id}/addresses/{addressId}/main`: define um endereço como o endereço principal de uma pessoa

## Testes Unitários

Os testes unitários podem ser executados usando o comando mvn test na raiz do projeto.

## Notas

Este projeto foi desenvolvido como um exemplo e pode ser usado como base para projetos semelhantes. Ele ainda pode ser melhorado e refinado de acordo com as necessidades específicas do projeto.
