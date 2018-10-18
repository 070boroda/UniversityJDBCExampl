-- Вывод групп где меньше 10 студентов
SELECT name, students.group_id FROM students,groups WHERE students.group_id=groups.group_id
       GROUP BY students.group_id,groups.name
       HAVING COUNT(students.group_id)<10;
         
-- удаление студентов по имени группы 
DELETE FROM courses_students
       WHERE student_id < 4;       
DELETE FROM students
       WHERE students.group_id IN(SELECT group_id
       FROM groups
       WHERE name = 'SR-01');   
       
-- Вывод имен студентов и предметов(курсов) которые им соответствуют
SELECT first_name, last_name, name FROM students
       INNER JOIN courses_students ON students.student_id = courses_students.student_id
       INNER JOIN courses ON courses.course_id = courses_students.course_id;        
              