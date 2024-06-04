DROP TABLE IF EXISTS artists;

CREATE TABLE artists (
	artist_id INT,
    name VARCHAR,
    nationality VARCHAR,
    gender VARCHAR,
    birth_year INT,
    death_year INT
);

CREATE EXTENSION IF NOT EXISTS pg_trgm;