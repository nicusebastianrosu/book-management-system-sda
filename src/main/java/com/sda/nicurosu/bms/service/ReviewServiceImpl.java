package com.sda.nicurosu.bms.service;

import com.sda.nicurosu.bms.model.Book;
import com.sda.nicurosu.bms.model.Review;
import com.sda.nicurosu.bms.repository.BookRepository;
import com.sda.nicurosu.bms.repository.BookRepositoryImpl;
import com.sda.nicurosu.bms.repository.ReviewRepository;
import com.sda.nicurosu.bms.service.exceptions.BookNotFountException;

public class ReviewServiceImpl implements ReviewService {

    private BookRepository bookRepository;
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl() {
        bookRepository = new BookRepositoryImpl();
        reviewRepository = new ReviewRepositoryImpl();
    }

    @Override
    public void createReview(String score, String comment, Integer bookId) throws BookNotFountException {

        Book book = bookRepository.findById(bookId);
        if (book != null) {
            Review review = new Review();
            review.setScore(score);
            review.setComment(comment);
            review.setBook(book);
            reviewRepository.createEntity(review);
        } else {
            throw new BookNotFountException("Book not found", bookId);
        }
    }
}
