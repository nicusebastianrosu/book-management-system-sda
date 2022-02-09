package com.sda.nicurosu.bms.service.exceptions;

public class BookNotFountException extends Exception {
    private Integer bookId;

    public BookNotFountException(String message, Integer bookId) {
        super(message);
        this.bookId = bookId;
    }

    public Integer getBookId() {
        return bookId;
    }
}
