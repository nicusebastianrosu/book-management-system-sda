package com.sda.nicurosu.bms.service;

import com.sda.nicurosu.bms.model.Author;
import com.sda.nicurosu.bms.repository.AuthorRepository;
import com.sda.nicurosu.bms.repository.AuthorRepositoryImpl;

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
}
