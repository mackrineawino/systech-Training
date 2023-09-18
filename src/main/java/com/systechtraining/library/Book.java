package com.systechtraining.library;

public class Book {
    private String isbnNumber;
    private String title;
    private com.systechtraining.encapsulation.Student borrower;
    

    public Book(){

    }
    public Book(String isbnNumber, String title){
         this.isbnNumber= isbnNumber;
         this.title = title;
        
    }
    public String getIsbnNumber() {
        return isbnNumber;
    }
    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public com.systechtraining.encapsulation.Student getBorrower() {
        return borrower;
    }

    public void setBorrower(com.systechtraining.encapsulation.Student student) {
        this.borrower = student;
    }
   
    
}
