package com.sda.nicurosu.bms.service;

import com.sda.nicurosu.bms.model.Author;
import com.sda.nicurosu.bms.model.Book;
import com.sda.nicurosu.bms.repository.AuthorRepository;
import com.sda.nicurosu.bms.repository.AuthorRepositoryImpl;
import com.sda.nicurosu.bms.repository.BookRepository;
import com.sda.nicurosu.bms.repository.BookRepositoryImpl;
import com.sda.nicurosu.bms.service.exceptions.AuthorNotFoundException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    @Override
    public void importBooksFromFile() {
        Path bookFileAbsolutePath = Paths.get("C:\\Users\\Rosu\\Documents\\book-management-system-sda\\data\\books.txt");
        try {
            Files.lines(bookFileAbsolutePath)
                    .filter(line -> line != null)
                    .filter(line -> !line.isEmpty())
                    .skip(1)
                    .forEach(line -> {
                        try {
                            String[] elements = line.split("\\|");
                            createBook(elements[0], elements[1], elements[2], Integer.parseInt(elements[3]));

                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
