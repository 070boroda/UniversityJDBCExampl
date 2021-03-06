package com.foxminded.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foxminded.entity.Student;

public class StudentDao extends AbstractDao<Integer, Student> {
    private final static String SQL_CREATE = "INSERT INTO students (id,first_name,last_name,id_group) VALUES (DEFAULT,?,?,?);";
    private final static String SQL_DELETE = "DELETE FROM students WHERE id =?;";
    private final static String SQL_UPDATE_NAME_BY_ID = "UPDATE students SET first_name =?, last_name =?, id_group=? WHERE id =?;";
    private final static String SQL_GET_BY_ID = "SELECT * FROM students WHERE id=?;";
    private final static String SQL_GET_ALL = "SELECT * FROM students;";
    private final static String SQL_UPDATE_GROUP_BY_ID = "UPDATE students SET id_group =? WHERE id =?;";
    private Executor executor;

    public StudentDao() {
        this.executor = new Executor();
    }

    @Override
    public Student getById(Integer id) throws SQLException {
        return executor.execQuery(SQL_GET_BY_ID, result -> {
            result.next();
            return new Student(result.getInt("id"), result.getString("first_name"), result.getString("last_name"));
        }, id);
    }

    @Override
    public void delete(Student entity) throws SQLException {
        executor.execUpdate(SQL_DELETE, entity.getId());
    }

    public void create(Student student) throws SQLException {
        executor.execUpdate(SQL_CREATE, student.getFirstName(), student.getSecondName(), student.getIdgroup());
    }

    @Override
    public List<Student> getAll() throws SQLException {
        return executor.execQuery(SQL_GET_ALL, result -> {
            List<Student> all = new ArrayList<>();
            while (result.next()) {
                all.add(new Student(result.getInt("id"), result.getString("first_name"), result.getString("last_name"),
                        result.getInt("id_group")));
            }
            return all;
        });
    }

    @Override
    public void update(Student entity, Integer id) throws SQLException {
        executor.execUpdate(SQL_UPDATE_NAME_BY_ID, entity.getFirstName(), entity.getSecondName(),entity.getIdgroup(), id);
    }

    public void updateGroupId(Student entity, Integer id) throws SQLException {
        executor.execUpdate(SQL_UPDATE_GROUP_BY_ID, entity.getIdgroup(), id);
    }
}
