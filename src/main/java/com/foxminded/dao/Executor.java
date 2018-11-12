package com.foxminded.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Executor {

    public void execUpdate(String update, Object... parametrs) throws SQLException {
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(update)) {
            log.info("execUpdate() is start");
            int count = 1;
            for (Object value : parametrs) {
                statement.setObject(count++, value);
            }
            statement.executeUpdate();
            log.info("execUpdate() is end");
        }
    }

    public <T> T execQuery(String query, ResultHandler<T> handler, Object... parametrs) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            log.info("execQuery() is start");
            int count = 1;
            for (Object value : parametrs) {
                stmt.setObject(count++, value);
            }
            stmt.executeQuery();
            ResultSet result = stmt.getResultSet();
            T value = handler.handle(result);
            result.close();
            log.info("execQuery() is end");
            return value;
        }
    }

    public static Connection getConnection() {
        Properties property = new Properties();
        log.info("Start connection");
        try (FileInputStream fin = new FileInputStream("./University/src/main/resources/config.properties")) {
            property.load(fin);
            String url = property.getProperty("db.host");
            String name = property.getProperty("db.login");
            String password = property.getProperty("db.pas");
            return DriverManager.getConnection(url, name, password);
        } catch (RuntimeException | IOException | SQLException e) {
            log.error("Connection is FALSE");
            e.printStackTrace();
        }
        return null;
    }
}
