package com.sda.nicurosu.bms.repository;

import com.sda.nicurosu.bms.model.Book;

public interface BookRepository extends BaseRepository<Book, Integer> {

    void createBook(Book book);

    // Book findById(Integer id);
}
