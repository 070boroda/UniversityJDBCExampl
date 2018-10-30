CREATE TABLE IF NOT EXISTS groups( 
group_id int PRIMARY KEY,
name varchar(10));

CREATE TABLE IF NOT EXISTS students (
student_id int PRIMARY KEY, 
group_id int REFERENCES groups(group_id), 
first_name varchar(15), 
last_name varchar(15));

CREATE TABLE IF NOT EXISTS courses (
course_id int PRIMARY KEY, 
name varchar(10), 
description varchar(10));

CREATE TABLE courses_students (
student_id int REFERENCES students(student_id),
course_id int REFERENCES  courses(course_id),
PRIMARY KEY (student_id,course_id));
