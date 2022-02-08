package com.sda.nicurosu.bms.repository;

import com.sda.nicurosu.bms.model.Book;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book, Integer> implements BookRepository {
    public BookRepositoryImpl() {
        super(Book.class);
    }

    @Override
    public void createBook(Book book) {
//        Session session = SessionManager.getSessionFactory().openSession();
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//            session.save(book);
//            transaction.commit();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//        session.close();
        createEntity(book);
    }
}
