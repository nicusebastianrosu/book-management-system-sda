package com.sda.nicurosu.bms.repository;

import com.sda.nicurosu.bms.model.Book;
import com.sda.nicurosu.bms.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public void createBook(Book book) {
        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }
}
