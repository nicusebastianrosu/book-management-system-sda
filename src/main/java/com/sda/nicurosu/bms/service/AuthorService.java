package com.sda.nicurosu.bms.service;

import com.sda.nicurosu.bms.model.Author;

import java.util.List;

public interface AuthorService {

    void createAuthor(String firstName, String lastName);
    List<Author> findAll();
}
