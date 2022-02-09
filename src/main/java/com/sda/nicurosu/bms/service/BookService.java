package com.sda.nicurosu.bms.service;

import com.sda.nicurosu.bms.model.Review;
import com.sda.nicurosu.bms.service.exceptions.AuthorNotFoundException;
import com.sda.nicurosu.bms.service.exceptions.BookNotFountException;

import java.util.List;

public interface BookService {

    void createBook(String isbn, String title, String description);

    void createBook(String isbn, String title, String description, Integer authorId) throws AuthorNotFoundException;

    void importBooksFromFile();

    List<Review> getReviewsForBook(Integer bookId) throws BookNotFountException;

}
