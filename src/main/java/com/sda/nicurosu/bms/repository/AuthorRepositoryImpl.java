package com.sda.nicurosu.bms.repository;

import com.sda.nicurosu.bms.model.Author;
import com.sda.nicurosu.bms.utils.SessionManager;
import org.hibernate.Session;

import java.util.List;

public class AuthorRepositoryImpl extends BaseRepositoryImpl<Author, Integer> implements AuthorRepository {

    public AuthorRepositoryImpl() {
        super(Author.class);
    }

    @Override
    public void createAuthor(Author author) {
        createEntity(author);
//        Session session = SessionManager.getSessionFactory().openSession();
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//            session.save(author);
//            transaction.commit();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//        session.close();
    }

//    @Override
//    public Author findById(Integer id) {
//        Session session = SessionManager.getSessionFactory().openSession();
//        Author author = session.find(Author.class, id);
//        session.close();
//        return author;
//    }

    @Override
    public List<Author> findAll() {
        Session session = SessionManager.getSessionFactory().openSession();
        List<Author> authors = session.createQuery("from Author", Author.class).list();
        session.close();
        return authors;
    }
}
