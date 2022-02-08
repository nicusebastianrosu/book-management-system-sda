package com.sda.nicurosu.bms.service;

import com.sda.nicurosu.bms.model.Author;
import com.sda.nicurosu.bms.repository.AuthorRepository;
import com.sda.nicurosu.bms.repository.AuthorRepositoryImpl;
import com.sda.nicurosu.bms.service.exceptions.AuthorNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl() {
        authorRepository = new AuthorRepositoryImpl();
    }

    @Override
    public void createAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.createAuthor(author);

    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = authorRepository.findAll();
        return authors;
    }

    @Override
    public void importAuthorsFromFile() {
        //Path authorsFilePath = Paths.get("/data/authors.txt");
        Path authorsFileAbsolutePath = Paths.get("C:\\Users\\Rosu\\Documents\\book-management-system-sda\\data\\authors.txt");
        try {
            Files.lines(authorsFileAbsolutePath)
                    .filter(line -> line != null)
                    .filter(line -> !line.isEmpty())
                    .skip(1)
                    .map(line -> {
                        try {
                            String[] lineElements = line.split("\\|");
                            Author author = new Author();
                            author.setFirstName(lineElements[0]);
                            author.setLastName(lineElements[1]);
                            return author;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .forEach(author -> {
                        if (author != null) {
                            authorRepository.createAuthor(author);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, String firstName, String lastName) throws AuthorNotFoundException {
        Author author = authorRepository.findById(id);
        if (author != null) {
            author.setFirstName(firstName);
            author.setLastName(lastName);
            authorRepository.update(author);
        } else {
            throw new AuthorNotFoundException("Author not found", id);
        }
    }

    @Override
    public void delete(Integer id) throws AuthorNotFoundException {
        Author author = authorRepository.findById(id);
        if (author != null) {

            authorRepository.delete(author);
        } else {
            throw new AuthorNotFoundException("Author not found", id);
        }

    }
}
