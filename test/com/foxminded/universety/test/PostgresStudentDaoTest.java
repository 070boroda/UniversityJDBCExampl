package com.foxminded.universety.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;
import com.foxminded.dao.postgres.PostgresStudentDao;
import com.foxminded.universety.Student;

public class PostgresStudentDaoTest {

    @Test
    public void GetByIdTest() throws SQLException {
        PostgresStudentDao studentdao = new PostgresStudentDao();
        Student dbstudent;
        dbstudent = studentdao.getById(1);
        Student studentTest = new Student();
        studentTest.setId(1);
        studentTest.setFirstName("putin");
        studentTest.setSecondName("alex");
        assertEquals(dbstudent, studentTest);
    }

}
