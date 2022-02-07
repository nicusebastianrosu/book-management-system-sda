package com.sda.nicurosu.bms.repository;

import com.sda.nicurosu.bms.model.Author;
import com.sda.nicurosu.bms.model.Book;
import com.sda.nicurosu.bms.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthorRepositoryImpl implements AuthorRepository {

    @Override
    public void createAuthor(Author author) {
        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    @Override
    public Author findById(Integer id) {
        Session session = SessionManager.getSessionFactory().openSession();
        Author author = session.find(Author.class, id);
        session.close();
        return author;
    }
}
