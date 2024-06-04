# Projet Spring Boot : Fuzzy Search avec PostgreSQL

## Description

Ce projet implémente une recherche floue (fuzzy search) en utilisant PostgreSQL et Spring Boot. Il permet de rechercher des artistes en utilisant trois méthodes différentes :
1. Recherche par trigrammes
2. Recherche phonétique
3. Recherche par distance

## Technologies

- Java 21
- Maven 3.9.6
- PostgreSQL 15
- Docker

## Installation

1. Clonez le dépôt

    ```bash
    git clone https://github.com/AlexisGadbin/pg-search-spring.git
    cd pg-search-spring
    ```

2. Configurez la base de données
    ```bash
    docker compose up -d
    ```

    Créez une base de données PostgreSQL et mettez à jour le fichier `application.properties` avec vos informations de connexion.

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/{{nom de votre base}}
    spring.datasource.username={{votre_utilisateur}}
    spring.datasource.password={{votre_mot_de_passe}}
    ```

3. Construisez et lancez l'application

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Endpoints

### Recherche par trigrammes

Recherche les artistes en utilisant la similarité de trigrammes.

- **URL** : `/artists/trigram`
- **Méthode** : `GET`
- **Paramètre** :
  - `q` (query) : la chaîne de caractères à rechercher (optionnel)

#### Exemple

```sh
curl -X GET "http://localhost:8080/artists/trigram?q=Clod money"
```

### Recherche phonétique

Recherche les artistes en utilisant la correspondance phonétique.

- **URL** : `/artists/phonetic`
- **Méthode** : `GET`
- **Paramètre** :
  - `q` (query) : la chaîne de caractères à rechercher (optionnel)

#### Exemple

```sh
curl -X GET "http://localhost:8080/artists/phonetic?q=fridakalo"
```

### Recherche par distance

Recherche les artistes en utilisant la distance de Levenshtein.

- **URL** : `/artists/distance`
- **Méthode** : `GET`
- **Paramètre** :
  - `q` (query) : la chaîne de caractères à rechercher (optionnel)

#### Exemple

```sh
curl -X GET "http://localhost:8080/artists/distance?q=John"
```

## Structure du projet

- **`fr.agadbin.search.common`** : Ce package contient les classes en commun entre les stratégies de recherche.
- **`fr.agadbin.search.distance_search`** : Ce package contient les classes pour la recherche par distance.
- **`fr.agadbin.search.phonetic_search`** : Ce package contient les classes pour la recherche phonétique.
- **`fr.agadbin.search.trigram_search`** : Ce package contient les classes pour la recherche par trigrammes.

## Contribuer

Les contributions sont les bienvenues ! 

## Licence

X
