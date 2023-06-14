package com.example.dao;

public interface BaseDao<T, ID> { //CRUD
    void create(T t);
    T read(ID id);
    void update(ID id, T t);
    void delete(ID id);
}
