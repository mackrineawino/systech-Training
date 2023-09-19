package com.systechtraining.interfaces.book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookControllerImpl implements BookController {

    private List<Book> books;

    public BookControllerImpl() {
        
        this.books = new ArrayList<>();
    }

    @Override
    public Book createBook(Book book) {
       book.setId(UUID.randomUUID().toString());
        books.add(book);
        return book;
    }

    @Override
    public Book findBook(String isbn) {
      
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        
        return null;
    }

    @Override
    public Book updateBook(String isbn, String title) {
      
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.setTitle(title);
                return book;
            }
        }
   
        return null;
    }

    @Override
    public void deleteBook(String isbn) {
        
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                return;
            }
        }
    }
}
