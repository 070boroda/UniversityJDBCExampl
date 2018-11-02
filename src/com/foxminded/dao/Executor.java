package com.foxminded.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Executor {

    static final Logger LOG = LoggerFactory.getLogger(Executor.class);

    public void execUpdate(String update, Object... parametrs) throws SQLException {
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(update)) {
            int count = 1;
            for (Object value : parametrs) {
                statement.setObject(count++, value);
            }
            statement.executeUpdate();
        }
    }

    public <T> T execQuery(String query, ResultHandler<T> handler, Object... parametrs) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            int count = 1;
            for (Object value : parametrs) {
                stmt.setObject(count++, value);
            }
            stmt.executeQuery();
            ResultSet result = stmt.getResultSet();
            T value = handler.handle(result);
            result.close();
            return value;
        }
    }

    public static Connection getConnection() {
        Properties property = new Properties();
        LOG.info("Start connection");
        try (FileInputStream fin = new FileInputStream("config.properties")) {
            property.load(fin);
            String url = property.getProperty("db.host");
            String name = property.getProperty("db.login");
            String password = property.getProperty("db.pas");
            return DriverManager.getConnection(url, name, password);
        } catch (RuntimeException | IOException | SQLException e) {
            LOG.error("Connection is FALSE");
            e.printStackTrace();
        }
        return null;
    }
}
