package com.sda.nicurosu.bms.repository;

import com.sda.nicurosu.bms.model.Author;

import java.util.List;

public interface AuthorRepository extends BaseRepository<Author, Integer>{

    void createAuthor(Author author);

    //Author findById(Integer id);

    List<Author> findAll();
}
