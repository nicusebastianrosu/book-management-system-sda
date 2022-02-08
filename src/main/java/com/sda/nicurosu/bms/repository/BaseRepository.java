package com.sda.nicurosu.bms.repository;

import com.sda.nicurosu.bms.model.Book;

public interface BaseRepository<T, ID> {

    void createEntity(T entity);

    T findById(ID id);

    void update(T Entity);

    void delete(T entity);
}
