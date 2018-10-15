package com.foxminded.dao.postgres;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.foxminded.dao.HandlerStatment;
import com.foxminded.dao.ResultHandler;

public class Executor<T> {

    public void execUpdate(String update, HandlerStatment handler) throws SQLException {
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(update)) {
            handler.handle(statement);
        }
    }

    public <T> T execQuery(String query, ResultHandler<T> handler) throws SQLException {
        try (Connection connection = getConnection(); Statement stmt = connection.createStatement()) {
            stmt.execute(query);
            ResultSet result = stmt.getResultSet();
            T value = handler.handle(result);
            result.close();
            return value;
        }
    }

    public static Connection getConnection() {
        Properties property = new Properties();
        try (FileInputStream fin = new FileInputStream("config.properties")) {
            property.load(fin);
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
}
