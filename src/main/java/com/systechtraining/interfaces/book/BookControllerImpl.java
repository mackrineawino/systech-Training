package com.systechtraining.interfaces.book;

import java.util.UUID;

public class BookControllerImpl implements BookController{

    @Override
    public Book createBook(Book book) {
        book.setId(UUID.randomUUID().toString());
        return book;
        
    }

    @Override
    public Book findBook(String isbn) {
     
    }

    @Override
    public Book updateBook(String isbn, String title) {
    
    }

    @Override
    public void deleteBook(String isbn) {
       
    }
    
}
