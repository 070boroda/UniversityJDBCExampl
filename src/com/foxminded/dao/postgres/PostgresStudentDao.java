package com.foxminded.dao.postgres;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.foxminded.dao.AbstractDao;
import com.foxminded.universety.Student;

public class PostgresStudentDao extends AbstractDao<Integer, Student> {
    final static String SQL_CREATE = "INSERT INTO students (id,first_name,last_name) VALUES (DEFAULT,?,?);";
    final static String SQL_DELETE = "DELETE FROM students WHERE first_name=? AND last_name=?;";
    final static String SQL_UPDATE_NAME_BY_ID = "UPDATE students SET first_name =? WHERE id =?;";
    final static String SQL_GET_BY_ID = "SELECT * FROM students WHERE id=?;";
    final static String SQL_GET_ALL = "SELECT * FROM students;";
    Executor executor;

    public PostgresStudentDao() {
        this.executor = new Executor();
    }

    @Override
    public Student getById(Integer id) throws SQLException {
        return (Student) executor.execQuery(SQL_GET_BY_ID, result -> {
            result.next();
            return new Student(result.getString(2), result.getString(3));
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
        List<Student> all = new ArrayList<>();
        return (List<Student>) executor.execQuery(SQL_GET_ALL, result -> {
            while (result.next()) {
                all.add(new Student(result.getString(2), result.getString(3)));
            }
            return all;
        });
    }

    @Override
    public void update(Student entity, Integer id) throws SQLException {
        executor.execUpdate(SQL_UPDATE_NAME_BY_ID, entity.getFirstName(), id);
    }
}
