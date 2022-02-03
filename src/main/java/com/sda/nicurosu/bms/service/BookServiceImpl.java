package com.sda.nicurosu.bms.service;

import com.sda.nicurosu.bms.model.Book;
import com.sda.nicurosu.bms.repository.BookRepository;
import com.sda.nicurosu.bms.repository.BookRepositoryImpl;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl() {
        bookRepository = new BookRepositoryImpl();
    }

    @Override
    public void createBook(String isbn, String title, String description) {
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setDescription(description);
        bookRepository.createBook(book);
    }
}
