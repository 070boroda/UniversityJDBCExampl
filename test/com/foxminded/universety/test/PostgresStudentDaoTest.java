package com.foxminded.universety.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import com.foxminded.dao.StudentDao;
import com.foxminded.entity.Student;

public class PostgresStudentDaoTest {

    @Test
    public void GetByIdTest() throws SQLException {
        StudentDao studentdao = new StudentDao();
        Student dbstudent;
        dbstudent = studentdao.getById(1);
        Student studentTest = new Student();
        studentTest.setId(1);
        studentTest.setFirstName("fdsa");
        studentTest.setSecondName("fgfgfdg");
        assertEquals(dbstudent, studentTest);
    }

}
