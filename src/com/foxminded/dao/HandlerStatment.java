package com.foxminded.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface HandlerStatment {
    void handle(PreparedStatement statement) throws SQLException;
}
