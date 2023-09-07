package com.systechtraining.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {

    final String DB_USERNAME = "Root";
    final String DB_PASSWORD = "Admin123";

    static boolean authorized = false;
    static Scanner scanner = new Scanner(System.in);
    private static int foodOption;
    private static boolean addFood = true;
    private List<Menu> drinks;
    private List<Menu> meals;
    private List<Menu> selectedItems;

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        restaurant.login();

        if (authorized) {

            restaurant.displayMenu();
            restaurant.addFood();
            restaurant.processPayment();

        } else {
            System.err.println("You have exhausted your login attempts. Please try again after a few minutes.");
        }
        scanner.close();

    }

    public Restaurant() {
        drinks = new ArrayList<>();
        meals = new ArrayList<>();
        selectedItems = new ArrayList<>();

        // Initialize menu items using constructors
        drinks.add(new Menu("CHAI", 15));
        drinks.add(new Menu("ANDAZI", 10));
        drinks.add(new Menu("TOSTI", 12));
        meals.add(new Menu("NDENGU AND ACCOMPLISHMENTS", 70));
        meals.add(new Menu("BEANS AND ACCOMPLISHMENTS", 70));
        meals.add(new Menu("PILAU VEG", 90));
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
        System.out.println("SYSTECH RESTAURANT:");
        System.out.println();
        System.out.println("DRINKS");
        System.out.println("---------------");
        System.out.println();
        int optionNumber = 1;
        for (Menu item : drinks) {
            String itemName = item.getName();
            int price = item.getPrice();
            String lineFormat = "%d. %s--------------------------%s%n";
            System.out.printf(lineFormat, optionNumber, itemName, price);
            optionNumber++;
        }
        System.out.println();
        System.out.println("MEALS");
        System.out.println("---------------");
        for (Menu item : meals) {
            String itemName = item.getName();
            int price = item.getPrice();
            String lineFormat = "%d. %s--------------------------%s%n";
            System.out.printf(lineFormat, optionNumber, itemName, price);
            optionNumber++;
        }

        System.out.println("7. Quit");
    }

    public void addFood() {

        while (addFood) {
            System.out.println("Enter your meal/drink option: ");
            foodOption = scanner.nextInt();
            scanner.nextLine();

            quitRestaurant();
            
            Menu selectedMenuItem;
            if (foodOption <= drinks.size()) {
                selectedMenuItem = drinks.get(foodOption - 1);
            } else {
                selectedMenuItem = meals.get(foodOption - drinks.size() - 1);
            }

            // Add the selected item to the order
            selectedItems.add(selectedMenuItem);

            System.out.println("Added " + selectedMenuItem.getName() + " to your order.");

            System.out.println("Do you want to enter another meal/drink option (Y/N): ");
            String additionalOption = scanner.nextLine();
            if (additionalOption.equalsIgnoreCase("N")) {
                addFood = false;
            }

        }
        System.out.println("---------------");

    }

    public void processPayment() {
        System.out.println("Proceed to payment (Y/N): ");
        String pay = scanner.nextLine();

        if (pay.equalsIgnoreCase("Y")) {
            displaySelectedMenuItems();
            double totalAmount = getTotalAmount();
            System.out.println("************************************************");
            System.out.println("Total:-----------------------------------" + totalAmount);
            System.out.println("Enter amount to pay: ");
            int paymentAmount = scanner.nextInt();
            scanner.nextLine();
            while (paymentAmount <= totalAmount) {
                System.out.println("Insufficient amount");
                System.out.println("Enter amount to pay: ");
                paymentAmount = scanner.nextInt();
                scanner.nextLine();
            }

            double balance = paymentAmount - totalAmount;
            System.out.println("Your balance is:-------------------------" + balance);

            System.out.println("************************************************");

        }

    }

    private void displaySelectedMenuItems() {
        System.out.println("Pay Now For: ");
        int optionNumber = 1;
        for (Menu item : selectedItems) {
            String itemName = item.getName();
            int price = item.getPrice();
            String lineFormat = "%d. %s--------------------------%s%n";
            System.out.printf(lineFormat, optionNumber, itemName, price);
            optionNumber++;
        }
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (Menu item : selectedItems) {
            totalAmount += item.getPrice();
        }
        return totalAmount;
    }

    private void quitRestaurant() {
        if (foodOption == 7) {
            System.out.println("Thank you for dining with us. Have a great day!");
            System.exit(0);
        }
    }
}
