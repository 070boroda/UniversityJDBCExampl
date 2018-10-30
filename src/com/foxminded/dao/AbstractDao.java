package com.foxminded.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<K, T> {
    public abstract T getById(K k) throws SQLException;

    public abstract void create(T t) throws SQLException;

    public List<T> getAll() throws SQLException {
        List<T> all = new ArrayList<>();
        return all;
    };

    public abstract void delete(T entity) throws SQLException;

    public abstract void update(T entity, K k) throws SQLException;

}
