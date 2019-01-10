
CREATE TABLE IF NOT EXISTS teachers (
id SERIAL PRIMARY KEY,  
first_name varchar(15), 
last_name varchar(15));

CREATE TABLE IF NOT EXISTS groups (
id SERIAL PRIMARY KEY,  
name varchar(15));

CREATE TABLE IF NOT EXISTS subjects (
id SERIAL PRIMARY KEY,  
name varchar(15));

CREATE TABLE IF NOT EXISTS students (
id SERIAL PRIMARY KEY,  
first_name varchar(15), 
last_name varchar(15),
id_group INT REFERENCES groups (id));

CREATE TABLE IF NOT EXISTS fields (
id SERIAL PRIMARY KEY,  
number_lesson varchar(15), 
day_lesson varchar(15),
id_group INT REFERENCES groups (id),
id_subject INT REFERENCES subjects (id));



