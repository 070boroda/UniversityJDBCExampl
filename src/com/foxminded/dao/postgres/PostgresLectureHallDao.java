package com.foxminded.dao.postgres;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.foxminded.dao.AbstractDao;
import com.foxminded.universety.LectureHall;

public class PostgresLectureHallDao extends AbstractDao<Integer, LectureHall> {
    final static String SQL_CREATE = "INSERT INTO LectureHall (id,number) VALUES (DEFAULT,?);";
    final static String SQL_DELETE = "DELETE FROM LectureHall WHERE number=?;";
    final static String SQL_UPDATE_NAME_BY_ID = "UPDATE LectureHall SET number =? WHERE id =?;";
    final static String SQL_GET_BY_ID = "SELECT * FROM LectureHall WHERE id=?;";
    final static String SQL_GET_ALL = "SELECT * FROM LectureHall;";
    Executor executor;

    public PostgresLectureHallDao() {
        this.executor = new Executor();
    }

    @Override
    public LectureHall getById(Integer id) throws SQLException {
        return (LectureHall) executor.execQuery(SQL_GET_BY_ID, result -> {
            result.next();
            return new LectureHall(result.getInt(1), result.getInt(2));
        }, id);
    }

    @Override
    public void create(LectureHall hall) throws SQLException {
        executor.execUpdate(SQL_CREATE, hall.getNumber());

    }

    @Override
    public List<LectureHall> getAll() throws SQLException {
        List<LectureHall> all = new ArrayList<>();
        return (List<LectureHall>) executor.execQuery(SQL_GET_ALL, result -> {
            while (result.next()) {
                all.add(new LectureHall(result.getInt(1), result.getInt(2)));
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
