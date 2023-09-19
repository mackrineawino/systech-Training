package com.systechtraining.interfaces.book;

public class BookDemo {
    public static void main(String[] args) {
        BookController b1 = new BookControllerImpl();
        Book book = new Book("22222", "thendfdhfhs", "dshgfgshdgfs");
        Book createdbook = b1.createBook(book);
        System.out.println(createdbook);

       Book found = b1.findBook(book.getIsbn());
       System.out.println(found);

       Book update = b1.updateBook(book.getIsbn(), "thh");
       System.out.println(update);

        b1.deleteBook(book.getIsbn());
        
    }
}
