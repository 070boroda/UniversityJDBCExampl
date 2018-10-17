package com.foxminded.main;

import java.sql.SQLException;

import com.foxminded.dao.postgres.PostgresGroupDao;
import com.foxminded.dao.postgres.PostgresStudentDao;
import com.foxminded.universety.Group;
import com.foxminded.universety.Student;
import com.foxminded.universety.University;

public class Main {

    public static void main(String[] args) throws SQLException {
        University run = new University();
        run.createUniversity();

        PostgresGroupDao fdfs = new PostgresGroupDao();
        Group ds = fdfs.getById(1);
        System.out.println(ds.getNumber());

    }
}
