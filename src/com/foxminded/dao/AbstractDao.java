package com.foxminded.dao;

import java.util.List;

public abstract class AbstractDao<K, T> {
    public abstract T getById(K k);

    public abstract boolean create(T entity);

    public abstract List<T> getAll();

    public abstract boolean delete(T entity);

    public abstract boolean update(T entity);

}
