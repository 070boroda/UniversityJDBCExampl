package com.foxminded.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foxminded.entity.Field;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldDao extends AbstractDao<Integer, Field> {
    private final static String SQL_CREATE = "INSERT INTO groups (id,name) VALUES (DEFAULT,?);";
    private final static String SQL_DELETE = "DELETE FROM groups WHERE id=?;";
    private final static String SQL_UPDATE_NAME_BY_ID = "UPDATE groups SET name =? WHERE id =?;";
    private final static String SQL_GET_BY_ID = "SELECT * FROM fields WHERE group_id=?;";
    private final static String SQL_GET_ALL = "SELECT * FROM fields;";
    private Executor executor;

    public FieldDao() {
        this.executor = new Executor();
    }

    @Override
    public Field getById(Integer id) throws SQLException {
        return executor.execQuery(SQL_GET_BY_ID, result -> {
            result.next();
            return new Field(result.getInt("id"));
        }, id);
    }

    @Override
    public void create(Field field) throws SQLException {
        executor.execUpdate(SQL_CREATE, field.getDayLesson(), field.getGroup(), field.getNumberLesson(),
                field.getSubject());

    }

    @Override
    public List<Field> getAll() throws SQLException {
        return executor.execQuery(SQL_GET_ALL, result -> {
            List<Field> all = new ArrayList<>();
            while (result.next()) {
                all.add(new Field(result.getInt("id")));
            }
            return all;
        });
    }

    @Override
    public void delete(Field entity) throws SQLException {
        executor.execUpdate(SQL_DELETE, entity.getId());

    }

    @Override
    public void update(Field entity, Integer id) throws SQLException {
        log.info("start groupdao Update name by ID");
        executor.execUpdate(SQL_UPDATE_NAME_BY_ID, entity.getGroup(), id);

    }

}
