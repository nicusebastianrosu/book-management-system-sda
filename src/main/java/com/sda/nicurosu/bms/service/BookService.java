package com.sda.nicurosu.bms.service;

import com.sda.nicurosu.bms.service.exceptions.AuthorNotFoundException;

public interface BookService {

    void createBook(String isbn, String title, String description);

    void createBook(String isbn, String title, String description, Integer authorId) throws AuthorNotFoundException;

    void importBooksFromFile();

}
