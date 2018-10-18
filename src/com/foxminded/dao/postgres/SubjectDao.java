package com.foxminded.dao.postgres;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.foxminded.dao.AbstractDao;
import com.foxminded.universety.Subject;

public class SubjectDao extends AbstractDao<Integer, Subject> {

    private final static String SQL_CREATE = "INSERT INTO subject (id,name) VALUES (DEFAULT,?);";
    private final static String SQL_DELETE = "DELETE FROM subject WHERE name=?;";
    private final static String SQL_UPDATE_NAME_BY_ID = "UPDATE subject SET name =? WHERE id =?;";
    private final static String SQL_GET_BY_ID = "SELECT * FROM subject WHERE id=?;";
    private final static String SQL_GET_ALL = "SELECT * FROM subject;";
    private Executor executor;

    public SubjectDao() {
        this.executor = new Executor();
    }

    @Override
    public Subject getById(Integer id) throws SQLException {
        return (Subject) executor.execQuery(SQL_GET_BY_ID, result -> {
            result.next();
            return new Subject(result.getInt(1), result.getString(2));
        }, id);
    }

    @Override
    public void create(Subject entity) throws SQLException {
        executor.execUpdate(SQL_CREATE, entity.getName());

    }

    @Override
    public List<Subject> getAll() throws SQLException {
        List<Subject> all = new ArrayList<>();
        return (List<Subject>) executor.execQuery(SQL_GET_ALL, result -> {
            while (result.next()) {
                all.add(new Subject(result.getInt(1), result.getString(2)));
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
