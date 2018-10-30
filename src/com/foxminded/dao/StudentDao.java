package com.foxminded.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foxminded.entity.Student;

public class StudentDao extends AbstractDao<Integer, Student> {
    private final static String SQL_CREATE = "INSERT INTO students (id,first_name,last_name) VALUES (DEFAULT,?,?);";
    private final static String SQL_DELETE = "DELETE FROM students WHERE first_name=? AND last_name=?;";
    private final static String SQL_UPDATE_NAME_BY_ID = "UPDATE students SET first_name =? WHERE id =?;";
    private final static String SQL_GET_BY_ID = "SELECT * FROM students WHERE id=?;";
    private final static String SQL_GET_ALL = "SELECT * FROM students;";
    private Executor<Student> executor;

    public StudentDao() {
        this.executor = new Executor<Student>();
    }

    @Override
    public Student getById(Integer id) throws SQLException {
        return executor.execQuery(SQL_GET_BY_ID, result -> {
            result.next();
            return new Student(result.getString("first_name"), result.getString("last_name"));
        }, id);
    }

    @Override
    public void delete(Student entity) throws SQLException {
        executor.execUpdate(SQL_DELETE, entity.getFirstName(), entity.getSecondName());
    }

    public void create(Student student) throws SQLException {
        executor.execUpdate(SQL_CREATE, student.getFirstName(), student.getSecondName());
    }

    @Override
    public List<Student> getAll() throws SQLException {
        return executor.execQuery(SQL_GET_ALL, result -> {
            List<Student> all = new ArrayList<>();
            while (result.next()) {
                all.add(new Student(result.getString("first_name"), result.getString("last_name")));
            }
            return all;
        });
    }

    @Override
    public void update(Student entity, Integer id) throws SQLException {
        executor.execUpdate(SQL_UPDATE_NAME_BY_ID, entity.getFirstName(), id);
    }
}
