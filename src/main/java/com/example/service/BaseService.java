package com.example.service;

public interface BaseService<T, ID> { //CRUD
    void create(T t);
    T read(ID id);
    void update(ID id ,T t);
    void delete(ID id);
}
