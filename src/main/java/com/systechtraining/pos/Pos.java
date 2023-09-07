package com.systechtraining.pos;

import java.util.Scanner;

public class Pos {

    final String DB_USERNAME = "Root";
    final String DB_PASSWORD = "Admin123";

    static boolean authorized = false;
    static Scanner scanner = new Scanner(System.in);

    private Item[] items; // Array to store items
    private int numberOfItems;
    private double total = 0.0;
    private double paymentAmount;
    private double change;

    public static void main(String[] args) {
        Pos pos = new Pos();

        pos.login();

        if (authorized) {
            boolean quit = false;

            // The while loop will enable you go back to the menu after a transcation
            // without program termination
            while (!quit) {
                pos.displayMenu();

                System.out.print("Choose an option: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        pos.addItems();

                        break;

                    case 2:
                        pos.makePayment();
                        break;

                    case 3:
                        pos.printReciept();
                        break;

                    default:
                        System.out.println("Please enter a valid option");
                        break;
                }
            }

        } else {
            System.err.println("You have exhausted your login attempts. Please try again after a few minutes.");
        }

    }

    public void login() {
        int loginAttempts = 0;

        while (loginAttempts < 3) {
            System.out.print("Welcome Dear Customer. To Proceed, Please Enter Your Username: ");
            String username = scanner.nextLine();

            System.out.print("Please Enter Your Password For Authentication: ");
            String password = scanner.nextLine();

            if (username.equals(DB_USERNAME) && password.equals(DB_PASSWORD)) {
                authorized = true;
                break;
            } else {
                loginAttempts++;
                System.out.println("Invalid username or password. Attempts remaining: " + (3 - loginAttempts));
            }
        }
    }

    public void displayMenu() {
        System.out.println("---------------");
        System.out.println();
        System.out.println("SYSTECH POS SYSTEM");
        System.out.println();
        System.out.println("---------------");
        System.out.println();
        System.out.println("1. ADD ITEM");
        System.out.println("2. MAKE PAYMENT");
        System.out.println("3. DISPLAY RECIEPT");
        System.out.println();

    }

    public void addItems() {
        boolean addMoreItems = true;

        while (addMoreItems) {
            System.out.print("Enter the number of Items: ");
            numberOfItems = scanner.nextInt();
            scanner.nextLine();

            items = new Item[numberOfItems];
            for (int i = 0; i < items.length; i++) {
                System.out.print("Enter the item code: ");
                int itemCode = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter the Quantity of the item: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter the unit price: ");
                double unitPrice = scanner.nextDouble();
                scanner.nextLine();

                Item x = new Item(itemCode, quantity, unitPrice);
                items[i] = x;
            }
            System.out.println("Items added successfully");

            System.out.print("Do you want to add another item? (Y/N): ");
            String addMore = scanner.nextLine();
            if (addMore.equalsIgnoreCase("N")) {
                addMoreItems = false;
            }
        }

    }

    public void makePayment() {

        System.out.println("Item Code   Quantity   Unit Price   Total Value");

        for (Item item : items) {
            System.out.printf("%-12d%-11d%-12.2f%-13.2f%n",
                    item.getItemCode(),
                    item.getQuantity(),
                    item.getUnitPrice(),
                    (item.getQuantity() * item.getUnitPrice()));

            total += (item.getQuantity() * item.getUnitPrice());
        }
        System.out.println();
        System.out.println("************************************************");
        System.out.println("Total: " + total);
        System.out.println("************************************************");
        System.out.print("Enter the amount given by customer: ");
        paymentAmount = scanner.nextInt();
        change = paymentAmount - total;

        System.out.println("Change: " + change);
        System.out.println("_____");
        System.out.println("************************************************");
        System.out.println("THANK YOU FOR SHOPPING WITH US!");
        System.out.println("************************************************");
    }

    public void printReciept() {
        System.out.println("Item Code   Quantity   Unit Price   Total Value");

        for (Item item : items) {
            System.out.printf("%-12d%-11d%-12.2f%-13.2f%n",
                    item.getItemCode(),
                    item.getQuantity(),
                    item.getUnitPrice(),
                    (item.getQuantity() * item.getUnitPrice()));

            total += (item.getQuantity() * item.getUnitPrice());
        }
        System.out.println();
        System.out.println("************************************************");
        System.out.println("Total: " + total);
        System.out.println("************************************************");
        System.out.println("Payment Amount: "+ paymentAmount);
        System.out.println("Change: "+ change);
        System.out.println("_____");
        System.out.println("************************************************");
        System.out.println("THANK YOU FOR SHOPPING WITH US!");
        System.out.println("************************************************");
    }
}
