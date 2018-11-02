package com.foxminded.main;

import java.sql.SQLException;

import com.foxminded.dao.StudentDao;

public class Main {

    public static void main(String[] args) throws SQLException {
        StudentDao studD = new StudentDao();
        studD.getById(1);

    }
}
