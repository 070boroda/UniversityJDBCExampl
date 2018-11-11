package main.java.com.foxminded.main;

import java.sql.SQLException;

import main.java.com.foxminded.entity.University;

public class Main {

    public static void main(String[] args) throws SQLException {

        University un = new University();
        un.createUniversity();

    }
}
