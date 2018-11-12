INSERT INTO courses (course_id, name,description)
VALUES     (1,'Programing', 'Prog_learn'),
	  	   (2,'Math', 'Math_learn'),
	       (3,'English', 'Eng_learn');

INSERT INTO groups(group_id, name)
VALUES( 1,'SR-01'),
	  ( 2,'SR-02'),
	  ( 3,'SR-03'),
	  ( 4,'SR-04'),
	  ( 5,'SR-05');
	  
INSERT INTO students(student_id, group_id, first_name,last_name)
VALUES 
	   (1, 1, 'putin','alex'),
       (2, 1, 'merkel','uipo'),
	   (3, 2, 'gorbachev','alex'),
       (4, 2, 'rty','uipo'),
	   (5, 2, 'put','alex'),
       (6, 3, 'rty','uipo'),
	   (7, 3, 'put','alex'),
       (8, 3, 'rty','uipo'),
	   (9, 3, 'put','alex'),
       (10,3, 'rty','uipo'),
	   (11,3, 'put','alex'),  
	   (12,3, 'luk','alex'),
       (13,3, 'shnek','uipo'),
	   (14,3, 'gavr','alex'),
       (15,3, 'mavr','uipo'),
	   (16,3, 'trah','alex'),
       (17,3, 'shmah','uipo'),
	   (18,3, 'bash','alex');
	   
INSERT INTO courses_students(student_id,course_id)
VALUES (1,1),
	   (1,2),
	   (2,1),
	   (2,3),
	   (3,3),
	   (3,2);
	   
INSERT INTO subjects (name) VALUES
('Geographic'),
('Mathematik'),
('English'),
('Programin');

