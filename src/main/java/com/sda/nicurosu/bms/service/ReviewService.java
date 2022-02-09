package com.sda.nicurosu.bms.service;

import com.sda.nicurosu.bms.service.exceptions.BookNotFountException;

public interface ReviewService {
    void createReview(String score, String comment, Integer bookId) throws BookNotFountException;

}

