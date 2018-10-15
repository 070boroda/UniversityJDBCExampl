package com.foxminded.dao.postgres;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.foxminded.dao.ResultHandler;

public class Executor<T> {

    private final Connection connection;

    public Executor() {
        this.connection = getConnection();
        System.out.println("Open connection");
    }

    public void execUpdate(String update) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(update);
        stmt.close();
        closeConnection(connection);
    }

    public <T> T execQuery(String query, ResultHandler<T> handler) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        ResultSet result = stmt.getResultSet();
        T value = handler.handle(result);
        result.close();
        stmt.close();
        closeConnection(connection);
        return value;
    }

    public static Connection getConnection() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("config.properties");
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

    public static void closeConnection(Connection connection) {
        if (connection != null)
            try {
                connection.close();
                System.out.println("Close connection");
            } catch (SQLException e) {
                System.err.println("Connection don't close");
                e.printStackTrace();
            }
    }

}
