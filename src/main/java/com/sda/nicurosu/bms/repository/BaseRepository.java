package com.sda.nicurosu.bms.repository;

public interface BaseRepository<T, ID> {

    void createEntity(T entity);

    T findById(ID id);


}
