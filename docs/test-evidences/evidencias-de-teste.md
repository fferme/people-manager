# Evidência de Testes

## Criando uma pessoa

- Usando requisição HTTP POST `(/api/person)` para criar uma pessoa

  ![1673474119224](image/Test-Evidences/1673474119224.png)

  ![1673474128917](image/Test-Evidences/1673474128917.png)
- Entidades criadas mostradas no banco de dados H2

  ![1673474457763](image/Test-Evidences/1673474457763.png)

---

## Atualizando uma pessoa

- Usando requisição HTTP PUT `(/api/person/{id})` para atualizar dados da pessoa

  ![1673484562783](image/Test-Evidences/1673484562783.png)
- Entidade atualizada mostrada no banco de dados H2

  ![1673484615889](image/Test-Evidences/1673484615889.png)

---

## Deletando dados de uma pessoa

- Usando requisição HTTP DELETE `(/api/person/{id})` para apagar dados da pessoa

  ![1673485350243](image/Test-Evidences/1673485350243.png)
- Atualização da tabela sem a pessoa de id número 3 no banco de dados H2

  ![1673485389437](image/Test-Evidences/1673485389437.png)

---

## Lendo dados da pessoa

- Usando requisição HTTP GET `(/api/person/{id})` para recuperar dados de uma pessoa

  ![1673484980403](image/Test-Evidences/1673484980403.png)

## Lendo todos os dados das pessoas

- Usando requisição HTTP GET `(/api/person)` para recuperar todos os dados das pessoas

  ![1673485181025](image/Test-Evidences/1673485181025.png)

## Criando endereço para pessoa

- Usando requisição HTTP GET `(/api/person/{id})` para recuperar dados da pessoa

  ![1673575534728](image/Test-Evidences/1673575534728.png)
- Usando requisição HTTP POST `(/api/person/{id}/addresses)` para criar um endereço e associá-lo a pessoa

  ![1673577393755](image/Test-Evidences/1673577393755.png)
- Usando requisição HTTP POST `(/api/person/{id})` para recuperar dados da pessoa com o endereçõ adicionado

  ![1673577453795](image/Test-Evidences/1673577453795.png)

  ## Recuperando todos os endereços da pessoa
- Usando requisição HTTP GET `(/api/person/{id})` para recuperar dados da pessoa com todos os endereços

  ![1673581153525](image/Test-Evidences/1673581153525.png)
- Usando requisição HTTP GET `(/api/person/{id}/addresses)` para recuperar todos endereços dessa pessoa

  ![1673582093454](image/Test-Evidences/1673582093454.png)

  ---

  ## Recuperando endereço principal de uma pessoa
- Usando requisição HTTP GET `(/api/person/{id})` para recuperar dados de uma pessoa

  ![1673623489603](image/evidencias-de-teste/1673623489603.png)
- Usando requisição HTTP GET `(/api/person/{id}/addresses/main)` para recuperar endereço principal da pessoa

  ![1673623551253](image/evidencias-de-teste/1673623551253.png)
