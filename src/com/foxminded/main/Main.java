package com.foxminded.main;

import com.foxminded.dao.BaseConnection;
import com.foxminded.universety.University;

public class Main {

    public static void main(String[] args) {
        /*
         * University run = new University(); run.createUniversity();
         */
        BaseConnection connection = new BaseConnection();
        connection.connection();
    }

}
