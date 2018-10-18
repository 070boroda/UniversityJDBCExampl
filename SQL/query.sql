       -- Вывод двух смежных таблиц
	   SELECT first_name,last_name, name FROM students,groups;
	   
	   -- Вывод студентов с именем групп
	   SELECT students.first_name, students.last_name, groups.name  FROM students,groups 
       WHERE students.group_id=groups.group_id;
       
	   -- Вывод групп где меньше 10 студентов
	   SELECT (SELECT name FROM groups 
       WHERE students.group_id=groups.group_id), COUNT(*) AS students  FROM students
       GROUP BY group_id
       HAVING COUNT(group_id)<10;
       
	   -- удаление студентов по имени группы 
	   DELETE FROM students
       USING groups
       WHERE groups.group_id = students.group_id
       AND groups.name = 'SR-01';
       
	   -- Вывод имен студентов и предметов(курсов) которые им соответствуют
	   SELECT students.first_name, students.last_name, courses.name FROM students,courses, courses_students
       WHERE students.student_id = courses_students.student_id AND
       courses.course_id = courses_students.course_id;
        