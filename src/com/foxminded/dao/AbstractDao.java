package com.foxminded.dao;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao<K, T> {
    public abstract T getById(K k) throws SQLException;

    public abstract void create(String k, String n) throws SQLException;

    public abstract List<T> getAll();

    public abstract void delete(T entity) throws SQLException;

    public abstract void update(T entity, K k) throws SQLException;

}
