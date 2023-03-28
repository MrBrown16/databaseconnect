CREATE DATABASE employee;

USE employee;

CREATE TABLE workers(
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
name varchar(50),
age int
);

INSERT INTO workers(name, age) VALUES
( "Béla", 32),
( "Jani", 41),
( "Kata", 25);
