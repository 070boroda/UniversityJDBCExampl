
CREATE TABLE IF NOT EXISTS students (
id SERIAL PRIMARY KEY,  
first_name varchar(15), 
last_name varchar(15));

CREATE TABLE IF NOT EXISTS teachers (
id SERIAL PRIMARY KEY,  
first_name varchar(15), 
last_name varchar(15));

CREATE TABLE IF NOT EXISTS groups (
id SERIAL PRIMARY KEY,  
name varchar(15));



