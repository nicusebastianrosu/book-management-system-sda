package com.sda.nicurosu.bms.controller;

import com.sda.nicurosu.bms.service.BookService;
import com.sda.nicurosu.bms.service.BookServiceImpl;
import com.sda.nicurosu.bms.service.ReviewService;
import com.sda.nicurosu.bms.service.ReviewServiceImpl;
import com.sda.nicurosu.bms.service.exceptions.BookNotFountException;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Scanner;

public class REviewControllerImpl implements ReviewController {

    private final Scanner SCANNER = new Scanner(System.in);
    private ReviewService reviewService;
    private BookService bookService;

    public REviewControllerImpl() {
        this.reviewService = new ReviewServiceImpl();
        this.bookService = new BookServiceImpl();
    }

    @Override
    public void addReview() {

        System.out.println("book id");
        Integer bookId = Integer.parseInt(SCANNER.nextLine());
        System.out.println("The score:");
        String score = SCANNER.nextLine();
        System.out.println("Comment");
        String comment = SCANNER.nextLine();
        try {
            reviewService.createReview(score, comment, bookId);
        } catch (BookNotFountException e) {
            System.out.println("book not found");
        }

    }

    @Override
    public void getReviewForBook() {
        System.out.println("Please, insert book id");
        Integer bookId = Integer.parseInt(SCANNER.nextLine());
        try {

            bookService.getReviewsForBook(bookId)
                    .stream()
                    .limit(10)
                    .forEach(review -> {
                        System.out.println("Score: " + review.getScore());
                        System.out.println("Comment: " + review.getComment());
                    });

        } catch (BookNotFountException e) {
            System.out.println("Book not found");
        }
    }
}
