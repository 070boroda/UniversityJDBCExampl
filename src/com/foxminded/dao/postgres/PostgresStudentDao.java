package com.foxminded.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.foxminded.dao.AbstractDao;
import com.foxminded.universety.Student;

public class PostgresStudentDao extends AbstractDao<Integer, Student> {
    private static final String SQL_GET_BY_ID = "SELECT * FROM students WHERE id = ?;";
    private static final String SQL_CREATE = "INSERT INTO students (id,first_name,last_name) VALUES (DEFAULT,?,?);";
    private DaoFactoryConnection factoryconnect = new DaoFactoryConnection();;

    @Override
    public Student getById(Integer id) {
        Connection connection = null;
        PreparedStatement statment = null;
        Student studtemp = new Student();

        try {
            connection = factoryconnect.getConnection();
            statment = connection.prepareStatement(SQL_GET_BY_ID);
            statment.setInt(1, id);
            ResultSet result = statment.executeQuery();
            result.next();
            studtemp.setId(result.getInt(id));
            studtemp.setFirstName(result.getString("first_name"));
            studtemp.setSecondName(result.getString("last_name"));

        } catch (SQLException e) {
            System.err.println("student getbyid error");
            e.printStackTrace();
        } finally {
            if (statment != null)
                try {
                    statment.close();
                } catch (SQLException e) {
                    System.err.println("Statment don't close");
                    e.printStackTrace();
                }
            if (connection != null) {
                factoryconnect.closeConnection(connection);
            }

        }
        return studtemp;
    }

    @Override
    public boolean create(Student student) {
        Connection connection = null;
        PreparedStatement statment = null;

        try {
            connection = factoryconnect.getConnection();
            statment = connection.prepareStatement(SQL_CREATE);
            statment.setString(1, student.getFirstName());
            statment.setString(2, student.getSecondName());
            statment.execute();
        } catch (SQLException e) {
            System.err.println("Connection false");
            e.printStackTrace();
        } finally {
            if (statment != null)
                try {
                    statment.close();
                } catch (SQLException e) {
                    System.err.println("statment don't close");
                    e.printStackTrace();
                }
            if (connection != null) {
                factoryconnect.closeConnection(connection);
            }

        }

        return true;
    }

    @Override
    public List<Student> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delete(Student entity) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Student entity) {
        // TODO Auto-generated method stub
        return false;
    }

}
