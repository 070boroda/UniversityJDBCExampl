package com.foxminded.universety.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.foxminded.dao.postgres.PostgresStudentDao;
import com.foxminded.universety.Student;

public class PostgresStudentDaoTest {

    @Test
    public void testGetById() {
        PostgresStudentDao studentdao = new PostgresStudentDao();
        Student dbstudent = new Student();
        dbstudent = studentdao.getById(1);
        Student studentTest = new Student();
        studentTest.setId(1);
        studentTest.setFirstName("putin");
        studentTest.setSecondName("alex");
        assertEquals(dbstudent, studentTest);

    }

}
