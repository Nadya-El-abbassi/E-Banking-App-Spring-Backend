
# 🏦 Bank Account Management – Backend (Spring Boot)

## 📌 Description du projet

Ce projet correspond à la **Partie 1 : Backend** d’une application de gestion bancaire développée avec **Spring Boot**.  
Il implémente une architecture **RESTful** complète incluant :

- JPA / Hibernate  
- Spring Data  
- DTOs  
- Services métier  
- Gestion des exceptions  
- Tests via API REST  
- Documentation avec Swagger (OpenAPI)




## 🧰 Technologies utilisées

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- MySQL
- Spring Web
- Lombok
- SpringDoc OpenAPI (Swagger)
- Maven

---

## 📂 Architecture du projet

<img src="images/img_31.png">


---

## 1️⃣ Création du projet Spring Boot

Le projet a été créé avec **Spring Initializr** en intégrant les dépendances nécessaires pour :
- Web
- JPA
- H2
- MySQL
- Lombok

---

## 2️⃣ Création des entités JPA

Les entités principales sont :
- `Customer`
- `BankAccount` (classe abstraite)
- `SavingAccount`
- `CurrentAccount`
- `AccountOperation`

---

## 🗄️ H2 Console

### Accès à la console H2

<img src="images/img.png">

On peut voir que **3 tables** ont été générées automatiquement :

<img src="images/img_1.png">

Dans la table **BankAccount**, une colonne supplémentaire `type` est ajoutée afin de gérer l’héritage :

<img src="images/img_2.png">

---

## 3️⃣ Création des interfaces JPA Repository

Les interfaces **Spring Data JPA Repository** permettent l’accès aux données sans écrire de requêtes SQL.

<img src="images/img_3.png">

---

## 4️⃣ Test de la couche DAO

Insertion de données dans la table **Customer** pour tester le fonctionnement :

<img src="images/img_4.png">

Les données sont bien insérées dans la base de données.

---

## 5️⃣ Héritage et stratégies JPA

### 🔹 SINGLE_TABLE

Création des comptes **CurrentAccount** et **SavingAccount**.  
Les données sont stockées dans **une seule table** grâce à `SINGLE_TABLE` :

<img src="images/img_5.png">

---

## ➕ Ajout des opérations bancaires

Ajout des opérations **débit / crédit** :

<img src="images/img_6.png">

Par défaut, `operation_type` est stocké sous forme numérique (`0 / 1`).  
Après ajout de :

```java
@Enumerated(EnumType.STRING)
````

On obtient :

<img src="images/img_7.png">

Les valeurs deviennent lisibles : **DEBIT / CREDIT**.

---

## 🔁 Changement de stratégie d’héritage

### 🔹 TABLE_PER_CLASS

SavingAccount :

<img src="images/img_8.png">

CurrentAccount :

<img src="images/img_9.png">

Après avoir déclaré `BankAccount` comme classe abstraite :

```java
public abstract class BankAccount {}
```

La table `bank_account` disparaît de la base :

<img src="images/img_10.png">

---

### 🔹 JOINED

Changement vers la stratégie `JOINED` :

<img src="images/img_11.png">

<img src="images/img_12.png">

<img src="images/img_13.png">

---

## 6️⃣ Passage de H2 vers MySQL

Ajout des dépendances MySQL
Puis configuration dans `application.properties`.

---

### Tables générées dans MySQL

Customer :

<img src="images/img_14.png">

AccountOperation :

<img src="images/img_15.png">

BankAccount :

<img src="images/img_16.png">

Les opérations **CRUD** fonctionnent correctement :

<img src="images/img_17.png">

---

## 7️⃣ DTOs (Data Transfer Objects)

Les **Entities** sont des modèles complexes, c’est pourquoi l’utilisation des **DTOs** est nécessaire :

<img src="images/img_18.png">

Si un champ n’est pas nécessaire, il peut être supprimé du DTO.
Exemple :

```java
// private String email;
```

Résultat à l’affichage :

<img src="images/img_19.png">

---

## 8️⃣ RestController

Exemple de service REST :

```java
@GetMapping("/customers/{id}")
public CustomerDTO getCustomer(@PathVariable(name = "id") Long customerId)
        throws CustomerNotFoundException {
    return bankAccountService.getCustomer(customerId);
}
```

Accès via navigateur :

```
http://localhost:8085/customers/{id}
```

<img src="images/img_20.png">

---

### Gestion des exceptions

Si le client n’existe pas dans la base de données :

<img src="images/img_21.png">

---

## 9️⃣ Documentation avec Swagger (OpenAPI)

Ajout de la dépendance **springdoc-openapi-ui** :

<img src="images/img_22.png">

Interface Swagger générée :

<img src="images/img_23.png">

---

## 🔍 Consulter les clients

### GET – Liste des clients

<img src="images/img_24.png">

---

### DELETE – Supprimer un client

<img src="images/img_25.png">

---

## 🔟 Tester les Web Services RESTful

Tests effectués via navigateur / Postman.

<img src="images/img_26.png">

---

## 📊 Consulter les comptes

Accès via :

```
http://localhost:8085/accounts
```

Affichage de la liste des comptes :

<img src="images/img_27.png">

<img src="images/img_28.png">

<img src="images/img_29.png">

<img src="images/img_30.png">

---

## ✅ Conclusion

Ce projet couvre l’ensemble des notions fondamentales du **Backend Spring Boot** :

* JPA & Hibernate
* Héritage
* DTOs
* REST API
* Gestion des exceptions
* Documentation API
* Migration H2 → MySQL

Il constitue une **base solide** pour une application bancaire complète.

---

📌 **Auteur** : *Nadya EL ABBASSI*
🎓 **Module** : Spring Boot / JPA / REST API

