package com.foxminded.dao;

import java.sql.Connection;
import java.sql.SQLException;
import com.foxminded.dao.postgres.PostgresGroupDao;
import com.foxminded.dao.postgres.PostgresLectureHallDao;
import com.foxminded.dao.postgres.PostgresStudentDao;
import com.foxminded.dao.postgres.PostgresSubjectDao;
import com.foxminded.dao.postgres.PostgresTeacherDao;

public interface DaoFactory {

    public Connection getConnection() throws SQLException;

    public PostgresGroupDao getGroupDao(Connection connection);

    public PostgresStudentDao getStudentDao(Connection connection);

    public PostgresLectureHallDao getHallDao(Connection connection);

    public PostgresSubjectDao getSubjectDao(Connection connection);

    public PostgresTeacherDao getTeacherDao(Connection connection);
}
