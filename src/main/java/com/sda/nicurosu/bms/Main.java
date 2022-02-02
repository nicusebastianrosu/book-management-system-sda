package com.sda.nicurosu.bms;

import com.sda.nicurosu.bms.model.Author;
import com.sda.nicurosu.bms.model.Book;
import com.sda.nicurosu.bms.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting BMS");
        SessionFactory sessionFactory = SessionManager.getSessionFactory();

        Session session = sessionFactory.openSession();

        Author author = new Author();
        author.setFirstName("Creanga");
        author.setLastName("Ion");

        session.save(author);

        Book book = new Book();
        book.setAuthor(author);
        book.setTitle("Amintiri");
        book.setIsbn("1111-1");
        book.setDescription("Povesti");

        session.save(book);

        session.close();

        SessionManager.shutDown();

    }
}
