package com.foxminded.main;

import java.sql.SQLException;
import com.foxminded.entity.University;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Main {

    public static void main(String[] args) throws SQLException {
    	
    	log.info("Start main");
        University un = new University();
        un.createUniversity();

    }
}
