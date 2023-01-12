# Test Evidences

## Creating a person

- Using http request POST `(/api/person)` to create a new person

  ![1673474119224](image/Test-Evidences/1673474119224.png)

  ![1673474128917](image/Test-Evidences/1673474128917.png)
- Entity created shown in H2 database

  ![1673474457763](image/Test-Evidences/1673474457763.png)

---

## Updating a person

- Using http request PUT `(/api/person/{id})` to update person's data

  ![1673484562783](image/Test-Evidences/1673484562783.png)
- Entity updated shown in H2 database

  ![1673484615889](image/Test-Evidences/1673484615889.png)

---

## Deleting person's data

- Using http request DELETE `(/api/person/{id})` to delete person's data

  ![1673485350243](image/Test-Evidences/1673485350243.png)
- Table updated without person number 3 shown in H2 database

  ![1673485389437](image/Test-Evidences/1673485389437.png)

---



## Reading person's data

- Using http request GET `(/api/person/{id})` to get person's data

  ![1673484980403](image/Test-Evidences/1673484980403.png)

## Reading all people's data

- Using http request GET `(/api/person)` to get all people's data

  ![1673485181025](image/Test-Evidences/1673485181025.png)
