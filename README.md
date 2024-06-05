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

1.  Clonez le dépôt

    ```bash
    git clone https://github.com/AlexisGadbin/pg-search-spring.git
    cd pg-search-spring
    ```

2.  Construisez et lancez les conteneurs avec Docker Compose

    ```bash
    docker-compose up --build
    ```

    Cela va :

    - Créer et démarrer un conteneur PostgreSQL avec une base de données nommée `pg_search`, utilisateur `root` et mot de passe `root`.
    - Construire l'application Spring Boot à partir du code source et lancer le conteneur.
    - Construire et démarrer l'application Next.js à partir du code source et lancer le conteneur.

3.  Accédez à l'application

    L'application Spring Boot sera accessible à l'adresse suivante :

    ```bash
    http://localhost:8080
    ```

    L'application Next.js sera accessible à l'adresse suivante :

    ```bash
    http://localhost:3000
    ```

    La base de données PostgreSQL sera accessible à l'adresse suivante :

    ```bash
    jdbc:postgresql://localhost:5432/pg_search
    ```

4.  (Optionnel) Pour arrêter et supprimer les conteneurs

    ```bash
    docker-compose down
    ```

### Notes

- Assurez-vous que les ports 5432 (pour PostgreSQL) et 8080 (pour l'application Spring Boot) sont libres sur votre machine avant de lancer les conteneurs.
- Vous pouvez personnaliser les informations de connexion à la base de données dans le fichier `docker-compose.yml` si nécessaire.

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
