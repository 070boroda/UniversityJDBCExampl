package com.foxminded.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseConnection {

    public static String URL = "jdbc:postgresql://localhost:5432/test1";
    public static String NAME = "postgres";
    public static String PASW = "root";

    public void connection() {
        Connection connection = null;
        Statement statmen = null;
        try {
            connection = DriverManager.getConnection(URL, NAME, PASW);
            System.out.println("Connection done");
            statmen = connection.createStatement();
            ResultSet rs = statmen.executeQuery("SELECT * FROM courses");
            PrintResult(rs);
        } catch (SQLException e) {
            System.out.println("connection false");
        } finally {
            if (statmen != null) {
                try {
                    statmen.close();
                    System.out.println("Statement close");
                } catch (SQLException e) {
                    System.out.println("Statement dont close");
                }
            }
            if (connection != null)
                try {
                    connection.close();
                    System.out.println("Connection close");
                } catch (SQLException e) {
                    System.out.println("Connection dont close");
                }
        }
    }

    public void PrintResult(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("description"));
            String name = rs.getString("name");
            System.out.println("name " + name);
        }
    }
}
