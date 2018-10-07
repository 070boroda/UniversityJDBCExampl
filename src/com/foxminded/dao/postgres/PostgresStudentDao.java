package com.foxminded.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.foxminded.dao.DaoStudent;
import com.foxminded.universety.Student;

public class PostgresStudentDao implements DaoStudent {
    private final Connection connection;

    public PostgresStudentDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Student create() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Student getById(int id) {
        Student studtemp = new Student();
        String sql = "SELECT * FROM students WHERE id =?;";
        try {
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setInt(1, id);
            ResultSet result = statment.executeQuery();
            result.next();
            studtemp.setFirstName(result.getString("first_name"));
            studtemp.setSecondName(result.getString("last_name"));

        } catch (SQLException e) {
            System.err.println("student getbyid error");
            e.printStackTrace();
        }
        return studtemp;
    }

    @Override
    public void update(Student student) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Student student) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Student> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
