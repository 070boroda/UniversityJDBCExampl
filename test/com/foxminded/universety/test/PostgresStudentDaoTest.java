package com.foxminded.universety.test;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.foxminded.dao.postgres.PostgresDaoFactory;
import com.foxminded.dao.postgres.PostgresStudentDao;
import com.foxminded.universety.Student;

public class PostgresStudentDaoTest {

    Connection connection;

    @Before
    public void before() throws Exception {

        PostgresDaoFactory factory = new PostgresDaoFactory();
        connection = factory.getConnection();
        factory.getGroupDao(connection);

    }

    @Test
    public void testGetById() {
        PostgresStudentDao studentdao = new PostgresStudentDao(connection);
        Student dbstudent = new Student();
        dbstudent = studentdao.getById(1);
        Student studentTest = new Student();
        studentTest.setId(1);
        studentTest.setFirstName("putin");
        studentTest.setSecondName("alex");
        assertEquals(dbstudent, studentdao);

    }

    @After
    public void after() throws Exception {
        connection.close();
    }

}
