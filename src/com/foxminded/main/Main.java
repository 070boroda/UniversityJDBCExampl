package com.foxminded.main;

import java.sql.SQLException;

import com.foxminded.dao.postgres.Executor;
import com.foxminded.universety.University;

public class Main {

    public static void main(String[] args) throws SQLException {
        Executor ex = new Executor();
        University run = new University();
        run.createUniversity();
    }
}
