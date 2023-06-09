CREATE DATABASE IF NOT EXISTS Person_App;

USE Person_App;

CREATE TABLE person
(
    id           INT PRIMARY KEY AUTO_INCREMENT NOT NULL ,
    first_name   VARCHAR(30)        NOT NULL,
    last_name    VARCHAR(30)        NOT NULL,
    birth_date   DATE               NOT NULL
);

INSERT INTO person (first_name, last_name, birth_date)
VALUES ('David', 'Guilmor', '1946-03-06');

INSERT INTO person (first_name, last_name, birth_date)
VALUES ('John', 'Doe', '1990-01-01');


