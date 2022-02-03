package com.sda.nicurosu.bms;

import com.sda.nicurosu.bms.utils.SessionManager;

public class OLDMain {
    public static void main(String[] args) {
        //System.out.println("Starting BMS");
        //SessionFactory sessionFactory = SessionManager.getSessionFactory();

        //Session session = sessionFactory.openSession();

//        Author author = new Author();
//        author.setFirstName("Creanga");
//        author.setLastName("Ion");
//
//        session.save(author);
//
//        Book book = new Book();
//        book.setAuthor(author);
//        book.setTitle("Amintiri");
//        book.setIsbn("1111-1");
//        book.setDescription("Povesti");
//
//        session.save(book);
//
//        Review review = new Review();
//        review.setBook(book);
//        review.setScore("10");
//        review.setComment("Nice book");
//        session.save(review);
//
//
//        Review review2 = new Review();
//        review2.setBook(book);
//        review2.setScore("10");
//        review2.setComment("Nice book");
//        session.save(review2);
//
//        Book book = session.find(Book.class, 3);
//        System.out.println(book.getReviews());
//
//        session.close();
//        // System.out.println(book.getReviews());
        SessionManager.shutDown();

    }
}
