package com.foxminded.dao.postgres;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.foxminded.dao.AbstractDao;
import com.foxminded.universety.Group;

public class PostgresGroupDao extends AbstractDao<Integer, Group> {

    final static String SQL_CREATE = "INSERT INTO groups (id,name) VALUES (DEFAULT,?);";
    final static String SQL_DELETE = "DELETE FROM groups WHERE name=?;";
    final static String SQL_UPDATE_NAME_BY_ID = "UPDATE groups SET name =? WHERE id =?;";
    final static String SQL_GET_BY_ID = "SELECT * FROM groups WHERE id=?;";
    final static String SQL_GET_ALL = "SELECT * FROM groups;";
    Executor executor;

    public PostgresGroupDao() {
        this.executor = new Executor();
    }

    @Override
    public Group getById(Integer id) throws SQLException {
        return (Group) executor.execQuery(SQL_GET_BY_ID, result -> {
            result.next();
            return new Group(result.getString(2));
        }, id);
    }

    @Override
    public void create(Group group) throws SQLException {
        executor.execUpdate(SQL_CREATE, group.getNumber());

    }

    @Override
    public List<Group> getAll() throws SQLException {
        List<Group> all = new ArrayList<>();
        return (List<Group>) executor.execQuery(SQL_GET_ALL, result -> {
            while (result.next()) {
                all.add(new Group(result.getString(2)));
            }
            return all;
        });
    }

    @Override
    public void delete(Group entity) throws SQLException {
        executor.execUpdate(SQL_DELETE, entity.getNumber());

    }

    @Override
    public void update(Group entity, Integer id) throws SQLException {
        executor.execUpdate(SQL_UPDATE_NAME_BY_ID, entity.getNumber(), id);

    }

}
