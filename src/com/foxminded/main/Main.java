package com.foxminded.main;

import java.sql.SQLException;

import com.foxminded.universety.University;

public class Main {

    public static void main(String[] args) throws SQLException {
        University run = new University();
        run.createUniversity();
    }
}
