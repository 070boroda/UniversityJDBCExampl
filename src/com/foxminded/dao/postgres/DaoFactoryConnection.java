package com.foxminded.dao.postgres;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.foxminded.dao.ConnectionFactory;

public class DaoFactoryConnection implements ConnectionFactory {

    FileInputStream fis;
    Properties property = new Properties();

    @Override
    public Connection getConnection() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("D:/Project2/University/Resources/config.properties");
            property.load(fis);

            String url = property.getProperty("db.host");
            String name = property.getProperty("db.login");
            String password = property.getProperty("db.pas");

            return DriverManager.getConnection(url, name, password);
        } catch (IOException | SQLException e) {
            System.err.println("File or data not found");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void closeConnection(Connection connection) {
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Connection don't close");
                e.printStackTrace();
            }
    }
}
