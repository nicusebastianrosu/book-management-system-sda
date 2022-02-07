package com.sda.nicurosu.bms.controller;

import com.sda.nicurosu.bms.service.exceptions.AuthorNotFoundException;

public interface BookController {
    void createBook();

    void createBookWithAuthor();
}
