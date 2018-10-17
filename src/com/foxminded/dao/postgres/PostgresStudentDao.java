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
    Executor executor;

    public PostgresStudentDao() {
        this.executor = new Executor();
    }

    @Override
    public Student getById(Integer id) throws SQLException {
        return (Student) executor.execQuery("SELECT * FROM students WHERE id=" + id + ";", result -> {
            result.next();
            return new Student(result.getString(2), result.getString(3));
        });
    }

    @Override
    public void delete(Student entity) throws SQLException {
        executor.execUpdate(SQL_DELETE, entity.getFirstName(), entity.getSecondName());
    }

    public void create(String first_name, String last_name) throws SQLException {
        executor.execUpdate(SQL_CREATE, first_name, last_name);
    }

    @Override
    public List<Student> getAll() throws SQLException {
        String sqlGetAll = "SELECT * FROM students;";
        List<Student> all = new ArrayList<>();
        return (List<Student>) executor.execQuery(sqlGetAll, result -> {
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
