package com.foxminded.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.foxminded.entity.Subject;

public class SubjectDao extends AbstractDao<Integer, Subject> {

    private final static String SQL_CREATE = "INSERT INTO subjects (id,name) VALUES (DEFAULT,?);";
    private final static String SQL_DELETE = "DELETE FROM subjects WHERE name=?;";
    private final static String SQL_UPDATE_NAME_BY_ID = "UPDATE subjects SET name =? WHERE id =?;";
    private final static String SQL_GET_BY_ID = "SELECT * FROM subjects WHERE id=?;";
    private final static String SQL_GET_ALL = "SELECT * FROM subjects;";
    private Executor executor;

    public SubjectDao() {
        this.executor = new Executor();
    }

    @Override
    public Subject getById(Integer id) throws SQLException {
        return executor.execQuery(SQL_GET_BY_ID, result -> {
            result.next();
            return new Subject(result.getInt("id"), result.getString("name"));
        }, id);
    }

    @Override
    public void create(Subject entity) throws SQLException {
        executor.execUpdate(SQL_CREATE, entity.getName());

    }

    @Override
    public List<Subject> getAll() throws SQLException {
        return executor.execQuery(SQL_GET_ALL, result -> {
            List<Subject> all = new ArrayList<>();
            while (result.next()) {
                all.add(new Subject(result.getInt("id"), result.getString("name")));
            }
            return all;
        });
    }

    @Override
    public void delete(Subject entity) throws SQLException {
        executor.execUpdate(SQL_DELETE, entity.getName());

    }

    @Override
    public void update(Subject entity, Integer id) throws SQLException {
        executor.execUpdate(SQL_UPDATE_NAME_BY_ID, entity.getName(), id);

    }
}
