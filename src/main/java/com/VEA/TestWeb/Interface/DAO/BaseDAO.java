package com.VEA.TestWeb.Interface.DAO;

import java.util.List;

public interface BaseDAO<T> {
    T getById(int id);
    List<T> getAll();
    boolean delete(T entity);
    boolean update(T entity);
    boolean create(T entity);
}
