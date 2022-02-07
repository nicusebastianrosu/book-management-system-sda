package com.sda.nicurosu.bms.service;

import com.sda.nicurosu.bms.model.Author;
import com.sda.nicurosu.bms.model.Book;
import com.sda.nicurosu.bms.repository.AuthorRepository;
import com.sda.nicurosu.bms.repository.AuthorRepositoryImpl;
import com.sda.nicurosu.bms.repository.BookRepository;
import com.sda.nicurosu.bms.repository.BookRepositoryImpl;
import com.sda.nicurosu.bms.service.exceptions.AuthorNotFoundException;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public BookServiceImpl() {
        bookRepository = new BookRepositoryImpl();
        authorRepository = new AuthorRepositoryImpl();

    }

    @Override
    public void createBook(String isbn, String title, String description) {
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setDescription(description);
        bookRepository.createBook(book);
    }

    @Override
    public void createBook(String isbn, String title, String description, Integer authorId) throws AuthorNotFoundException {
        Author author = authorRepository.findById(authorId);
        if (author != null) {
            Book book = new Book();
            book.setIsbn(isbn);
            book.setTitle(title);
            book.setDescription(description);
            book.setAuthor(author);
            bookRepository.createBook(book);
        } else {
            throw new AuthorNotFoundException("Author not found", authorId);
        }
    }
}
