package com.sda.nicurosu.bms.controller;

import com.sda.nicurosu.bms.service.BookService;
import com.sda.nicurosu.bms.service.BookServiceImpl;

import java.util.Scanner;

public class BookControllerImpl implements BookController {

    private static final Scanner SCANNER = new Scanner(System.in);

    private BookService bookService;

    public BookControllerImpl() {
        bookService = new BookServiceImpl();
    }

    @Override
    public void createBook() {
        System.out.println("Create book!");
        System.out.println("Please insert ISBN:");
        String isbn = SCANNER.nextLine();
        System.out.println("Please insert title:");
        String title = SCANNER.nextLine();
        System.out.println("Please insert description:");
        String description = SCANNER.nextLine();

        bookService.createBook(isbn, title, description);

    }
}
