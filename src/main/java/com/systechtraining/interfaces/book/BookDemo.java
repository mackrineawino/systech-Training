package com.systechtraining.interfaces.book;

public class BookDemo {
    public static void main(String[] args) {
        BookController b1 = new BookControllerImpl();
        Book book = new Book("22222", "thendfdhfhs", "dshgfgshdgfs");
        Book createdbook = b1.createBook(book);
        System.out.println(createdbook);
    }
}
