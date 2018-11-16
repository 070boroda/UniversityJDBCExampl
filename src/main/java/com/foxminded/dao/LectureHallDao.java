package com.foxminded.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.foxminded.entity.LectureHall;

public class LectureHallDao extends AbstractDao<Integer, LectureHall> {
    private final static String SQL_CREATE = "INSERT INTO LectureHall (id,number) VALUES (DEFAULT,?);";
    private final static String SQL_DELETE = "DELETE FROM LectureHall WHERE number=?;";
    private final static String SQL_UPDATE_NAME_BY_ID = "UPDATE LectureHall SET number =? WHERE id =?;";
    private final static String SQL_GET_BY_ID = "SELECT * FROM LectureHall WHERE id=?;";
    private final static String SQL_GET_ALL = "SELECT * FROM LectureHall;";
    private Executor executor;

    public LectureHallDao() {
        this.executor = new Executor();
    }

    @Override
    public LectureHall getById(Integer id) throws SQLException {
        return executor.execQuery(SQL_GET_BY_ID, result -> {
            result.next();
            return new LectureHall(result.getInt("id"), result.getInt("number"));
        }, id);
    }

    @Override
    public void create(LectureHall hall) throws SQLException {
        executor.execUpdate(SQL_CREATE, hall.getNumber());

    }

    @Override
    public List<LectureHall> getAll() throws SQLException {
        return executor.execQuery(SQL_GET_ALL, result -> {
            List<LectureHall> all = new ArrayList<>();
            while (result.next()) {
                all.add(new LectureHall(result.getInt("id"), result.getInt("number")));
            }
            return all;
        });
    }

    @Override
    public void delete(LectureHall entity) throws SQLException {
        executor.execUpdate(SQL_DELETE, entity.getNumber());
    }

    @Override
    public void update(LectureHall entity, Integer id) throws SQLException {
        executor.execUpdate(SQL_UPDATE_NAME_BY_ID, entity.getNumber(), id);

    }
}
