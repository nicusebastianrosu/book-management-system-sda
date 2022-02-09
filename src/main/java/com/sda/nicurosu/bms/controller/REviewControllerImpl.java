package com.sda.nicurosu.bms.controller;

import com.sda.nicurosu.bms.service.ReviewService;
import com.sda.nicurosu.bms.service.ReviewServiceImpl;
import com.sda.nicurosu.bms.service.exceptions.BookNotFountException;

import java.util.Scanner;

public class REviewControllerImpl implements ReviewController {

    private final Scanner SCANNER = new Scanner(System.in);
    private ReviewService reviewService;

    public REviewControllerImpl() {
        this.reviewService = new ReviewServiceImpl();
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
}
