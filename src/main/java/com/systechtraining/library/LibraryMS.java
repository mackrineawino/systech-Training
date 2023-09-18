package com.systechtraining.library;

import java.util.Scanner;

import com.systechtraining.encapsulation.Student;

public class LibraryMS {

    static Scanner scanner = new Scanner(System.in);
    final String DB_PASSWORD = "Admin123";
    static boolean authorized = false;
    private int numberOfBooks;
    Book[] books;

    public static void main(String[] args) {
        LibraryMS library = new LibraryMS();
        library.login();

        if (authorized) {
            boolean quit = false;
            while (!quit) {

                library.displayMenu();
                System.out.println();

                System.out.print("Choose an option: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        library.borrowBook();

                        break;

                    case 2:
                        library.viewBorrowedBooks();
                        break;

                    case 3:
                        library.returnBook();
                        break;

                    case 4:
                        library.exitSystem();
                        break;

                    default:
                        System.out.println("Please enter a valid option");
                        break;
                }
            }
        } else {
            System.err.println("You have exhausted your login attempts. Please try again after a few minutes.");
        }
        scanner.close();

    }

    public void login() {
        int loginAttempts = 0;

        while (loginAttempts < 3) {
            System.out.print(" Welcome Dear Customer. Please Enter Your Password For Authentication: ");
            String password = scanner.nextLine();

            if (password.equals(DB_PASSWORD)) {
                authorized = true;
                break;
            } else {
                loginAttempts++;
                System.out.println("Invalid password. Attempts remaining: " + (3 - loginAttempts));
            }
        }
    }

    public void displayMenu() {
        System.out.println("------------------------------------");
        System.out.println();
        System.out.println("SYSTECH Library Management syatem:");
        System.out.println();
        System.out.println("------------------------------------");
        System.out.println("1. Borrow" + " " + "a" + " " + "book");
        System.out.println("2. View borrowed books");
        System.out.println("3. Return" + " " + "a" + " " + "book");
        System.out.println("4. Quit");
    }

    public void borrowBook() {
        boolean addMorebooks = true;

        while (addMorebooks) {
            System.out.print("Enter the number of books to be borrowed: ");
            numberOfBooks = scanner.nextInt();
            scanner.nextLine();

            books = new Book[numberOfBooks];
            for (int i = 0; i < books.length; i++) {
                System.out.print("Enter the Students registration number: ");
                String studentRegNumber = scanner.nextLine();
            
                System.out.print("Enter the ISBN number: ");
                String isbnNumber = scanner.nextLine();
               
                System.out.print("Enter the title of the book: ");
                String title = scanner.nextLine();
            

                Book x = new Book(isbnNumber, title);
                books[i] = x;
                Student student = new Student(studentRegNumber);
                x.setBorrower(student);


            }
            System.out.println("Book borrowed successfully");
            System.out.print("Do you want to add another book? (Y/N): ");
            String addMore = scanner.nextLine();
            if (addMore.equalsIgnoreCase("N")) {
                addMorebooks = false;
            }
        }
    }

    public void viewBorrowedBooks() {
        System.out.println("Borrowed Books:");
        System.out.println("------------------");
    
        if (books != null && books.length > 0) {
            for (Book book : books) {
                if (book.getBorrower() != null) {
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("ISBN: " + book.getIsbnNumber());
                    System.out.println("Borrowed by Student: " + book.getBorrower().getStudentRegNumber());
                    System.out.println("------------------");
                }
            }
        } else {
            System.out.println("No books have been borrowed.");
        }
    }

    public void returnBook() {

    }

    public void exitSystem() {

    }

}
