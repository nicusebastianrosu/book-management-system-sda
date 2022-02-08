package com.sda.nicurosu.bms.controller;

import com.sda.nicurosu.bms.model.Author;
import com.sda.nicurosu.bms.service.AuthorService;
import com.sda.nicurosu.bms.service.AuthorServiceImpl;

import java.util.List;
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

    @Override
    public void viewAllAuthors() {
        System.out.println("All authors:");
        List<Author> authors = authorService.findAll();
        for (Author author : authors) {
            System.out.println("ID " + author.getId());
            System.out.println("FirstName: " + author.getFirstName());
            System.out.println("LastName: " + author.getLastName());
            System.out.println("---------------------");
        }
    }

    @Override
    public void updateAuthor() {

        System.out.println("Update Author");
        System.out.println("Insert ID:");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("First Name:");
        String firstName = SCANNER.nextLine();
        System.out.println("Last Name");
        String lastName = SCANNER.nextLine();
        try {
            authorService.update(id, firstName, lastName);
        } catch (Exception e) {
            System.out.println("Author not found");
        }

    }
}
