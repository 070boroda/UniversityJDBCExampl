package com.foxminded.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.foxminded.entity.Teacher;

public class TeacherDao extends AbstractDao<Integer, Teacher> {
    private final static String SQL_CREATE = "INSERT INTO teachers (id,first_name,last_name) VALUES (DEFAULT,?,?);";
    private final static String SQL_DELETE = "DELETE FROM teachers WHERE id=?";
    private final static String SQL_UPDATE_NAME_BY_ID = "UPDATE teachers SET first_name =?, last_name=? WHERE id =?;";
    private final static String SQL_GET_BY_ID = "SELECT * FROM teachers WHERE id=?;";
    private final static String SQL_GET_ALL = "SELECT * FROM teachers;";
    private Executor executor;

    public TeacherDao() {
        this.executor = new Executor();
    }

    @Override
    public Teacher getById(Integer id) throws SQLException {
        return executor.execQuery(SQL_GET_BY_ID, result -> {
            result.next();
            return new Teacher(result.getInt("id"), result.getString("first_name"), result.getString("last_name"));
        }, id);
    }

    @Override
    public void delete(Teacher entity) throws SQLException {
        executor.execUpdate(SQL_DELETE, entity.getId());
    }

    public void create(Teacher teacher) throws SQLException {
        executor.execUpdate(SQL_CREATE, teacher.getFirstName(), teacher.getSecondName());
    }

    @Override
    public List<Teacher> getAll() throws SQLException {
        return executor.execQuery(SQL_GET_ALL, result -> {
            List<Teacher> all = new ArrayList<>();
            while (result.next()) {
                all.add(new Teacher(result.getInt("id"),result.getString("first_name"), result.getString("last_name")));
            }
            return all;
        });
    }

    @Override
    public void update(Teacher entity, Integer id) throws SQLException {
        executor.execUpdate(SQL_UPDATE_NAME_BY_ID, entity.getFirstName(), entity.getSecondName(), id);
    }

}
