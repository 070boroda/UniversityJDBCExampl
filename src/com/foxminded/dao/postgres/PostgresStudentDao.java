package com.foxminded.dao.postgres;

import java.sql.SQLException;
import java.util.List;
import com.foxminded.dao.AbstractDao;
import com.foxminded.universety.Student;

public class PostgresStudentDao extends AbstractDao<Integer, Student> {
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

    public void create(String first_name, String last_name) throws SQLException {
        String sqlCreate = "INSERT INTO students (id,first_name,last_name) VALUES (DEFAULT,'" + first_name + "','"
                + last_name + "');";
        executor.execUpdate(sqlCreate);

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
