package com.foxminded.dao.postgres;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.foxminded.dao.DaoFactory;

public class PostgresDaoFactory implements DaoFactory {

    FileInputStream fis;
    Properties property = new Properties();

    @Override
    public Connection getConnection() throws SQLException {
        try {
            fis = new FileInputStream("D:/Project2/University/Resources/config.properties");
            property.load(fis);
        } catch (IOException e) {
            System.err.println("File or data not found");
            e.printStackTrace();
        }

        String url = property.getProperty("db.host");
        String name = property.getProperty("db.login");
        String password = property.getProperty("db.pas");

        return DriverManager.getConnection(url, name, password);
    }

    @Override
    public PostgresGroupDao getGroupDao(Connection connection) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PostgresStudentDao getStudentDao(Connection connection) {
        // TODO Auto-generated method stub
        return new PostgresStudentDao(connection);
    }

    @Override
    public PostgresLectureHallDao getHallDao(Connection connection) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PostgresSubjectDao getSubjectDao(Connection connection) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PostgresTeacherDao getTeacherDao(Connection connection) {
        // TODO Auto-generated method stub
        return null;
    }

}
