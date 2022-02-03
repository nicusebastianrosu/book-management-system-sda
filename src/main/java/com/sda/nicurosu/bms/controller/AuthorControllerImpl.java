package com.sda.nicurosu.bms.controller;

import com.sda.nicurosu.bms.service.AuthorService;
import com.sda.nicurosu.bms.service.AuthorServiceImpl;

import java.util.Scanner;

public class AuthorControllerImpl implements AuthorController {

    private static final Scanner SCANNER = new Scanner(System.in);

    private AuthorService authorService;

    public AuthorControllerImpl() {
        authorService = new AuthorServiceImpl();
    }

    @Override
    public void createAuthor() {
        System.out.println("Create author!");
        System.out.println("Please first name:");
        String firstName = SCANNER.nextLine();
        System.out.println("Please last name:");
        String lastName = SCANNER.nextLine();


        authorService.createAuthor(firstName, lastName);


    }
}
