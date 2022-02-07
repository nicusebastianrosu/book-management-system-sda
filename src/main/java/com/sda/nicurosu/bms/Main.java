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
            MenuOption menuOption = findByOption(option);
//            if (menuOption == null) {
//                System.out.println("Option is not valid");
//            } else {
//
//            }

            switch (menuOption) {
                case CREATE_BOOK:
                    bookController.createBook();
                    break;
                case CREATE_AUTHOR:
                    authorController.createAuthor();
                    break;
                case CREATE_BOOK_WITH_AUTHOR:
                    bookController.createBookWithAuthor();
                    break;
                case EXIT:
                    System.out.println("Finish, bye, bye");
                    break;
                default:
                    System.out.println("Option is not valid!");
            }
        } while (option == null || !option.equals("EXIT"));

        SessionManager.shutDown();

    }

    private static void printMenu() {
        System.out.println("Menu:");
        // MenuOption menuOption = MenuOption.CREATE_BOOK;
        for (MenuOption menuOption : MenuOption.values()) {
            if (!menuOption.equals(MenuOption.UNDEFINED)) {
                System.out.println(menuOption.getOption() + " -> " + menuOption.getDescription());
            }
        }

        //System.out.println("1: CREATE BOOK");
        //System.out.println("2: Create author");
        //System.out.println("EXIT: EXIT");
    }

    public static MenuOption findByOption(String option) {
        for (MenuOption menuOption : MenuOption.values()) {
            if (menuOption.getOption().equals(option)) {
                return menuOption;
            }
        }
        return MenuOption.UNDEFINED;
    }
}
