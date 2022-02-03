package com.sda.nicurosu.bms;

import com.sda.nicurosu.bms.controller.AuthorController;
import com.sda.nicurosu.bms.controller.AuthorControllerImpl;
import com.sda.nicurosu.bms.controller.BookController;
import com.sda.nicurosu.bms.controller.BookControllerImpl;
import com.sda.nicurosu.bms.model.Author;
import com.sda.nicurosu.bms.model.Book;
import com.sda.nicurosu.bms.model.Review;
import com.sda.nicurosu.bms.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        BookController bookController = new BookControllerImpl();
        AuthorController authorController = new AuthorControllerImpl();
        System.out.println("Booking Management is Running! Starting !!!");

        String option = null;
        do {
            printMenu();
            System.out.println("Please insert your option:");
            option = SCANNER.nextLine();
            switch (option) {
                case "1":
                    bookController.createBook();
                    break;
                case "2":
                    authorController.createAuthor();
                    break;

                case "EXIT":
                    System.out.println("Finish, bye, bye");
                    break;
                default:
                    System.out.println("Option is not valid!");
            }
        } while (option == null || !option.equals("EXIT"));

        SessionManager.shutDown();

    }

    private static void printMenu() {
        System.out.println("1: CREATE BOOK");
        System.out.println("2: Create author");
        System.out.println("EXIT: EXIT");
    }
}
