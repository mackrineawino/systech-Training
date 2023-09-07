package com.systechtraining.atmsimulator;

import java.util.Scanner;

public class AtmSimulator {
    // constants declarations
    final static String DB_USERNAME = "Root";
    final static String DB_PASSWORD = "Admin123";

    // varriable declaration
    double balance = 1000;

    // Initialize the scanner class for user inputs
    static Scanner scanner = new Scanner(System.in);

    // User prompted for Auth credentials
    static int loginAttempts = 0;
    static boolean authorized = false;

    public static void main(String[] args) {
        AtmSimulator atmSimulator = new AtmSimulator();
        atmSimulator.login();

        if (authorized) {

            boolean quit = false;

            // The while loop will enable you go back to the menu after a transcation
            // without program termination
            while (!quit) {

                atmSimulator.displayMenu();

                System.out.print("Please Choose Your Transaction: ");
                String transaction = scanner.nextLine();


                // use switch statement to enable the user pick diffent cases of the
                // transactions
                switch (transaction) {
                    case "1":
                        atmSimulator.welcomeMessage();
                        break;

                    case "2":
                        atmSimulator.depositCash();
                        break;

                    case "3":
                        atmSimulator.withdrawCash();
                        break;

                    case "4":
                        atmSimulator.transferCash();
                        break;

                    case "5":
                        atmSimulator.exitSystem();
                        quit = true;
                        break;

                    default:
                        System.err.println("Please input a valid transcation ID");
                        break;
                }
            }

        } else {
            System.err.println("You have exhausted your login attempts. Please try again after a few minutes.");
        }

        // End of If else statement

        scanner.close();

    }

    private void login() {
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

    private void displayMenu() {
        // Start of the Main menu
        System.out.println("***************");
        System.out.println();
        System.out.println("ATM SIMULATOR");
        System.out.println();

        // Use escape character to enable display of ""
        System.out.println("\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"");
        System.out.println();
        System.out.println("ATM SERVICES");
        System.out.println();
        System.out.println("_______________");
        System.out.println();
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdrawal");
        System.out.println("4. Transfer Cash");
        System.out.println("5. Quit");
        System.out.println();

        // Use escape character to enable display of ""
        System.out.println("\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"");
    }

    private void welcomeMessage() {
        System.out.println("Welcome " + DB_USERNAME);
        System.out.println("Your balance is Ksh: " + balance);
        askToGoBack();
    }

    private void depositCash() {
        System.out.print("How much would you like to deposit: ");
        int depositedAmount = scanner.nextInt();
        scanner.nextLine();
        balance = balance + depositedAmount;
        System.out.println("Deposit is sucessful. Available balance is Ksh: " + balance);
        askToGoBack();
    }

    private void withdrawCash() {
        System.out.print("How much would you like to Withdraw: ");
        int withdrawalAmount = scanner.nextInt();
        scanner.nextLine();
        if (withdrawalAmount > balance) {
            System.err.println("Failed: Not enough money in your account");
            System.err.println("Your Available balance is: " + balance);
            askToGoBack();
        } else {
            double withdrawalTax = (2.0 / 100) * withdrawalAmount;
            balance = (balance - (withdrawalAmount + withdrawalTax));
            System.out.println("Withdrawal is successful. Available balance is: " + balance);
            askToGoBack();
        }
    }

    private void transferCash() {
        System.out.print("How much would you like to transfer: ");
        int transferAmount = scanner.nextInt();
        scanner.nextLine();
        if (transferAmount > balance) {
            System.err.println("Failed: Not enough money in your account");
            System.err.println("Your Available balance is: " + balance);
            askToGoBack();
        } else {
            balance = balance - transferAmount;
            System.out.println("Cash transfered  successfully. Available balance is: " + balance);
            askToGoBack();
        }
    }

    private void exitSystem() {
        System.out.print("Are you sure you want to exit (Yes/No)? ");
        String exitPrompt = scanner.nextLine();
        if (exitPrompt.equalsIgnoreCase("Yes")) {
            System.out.println("Exiting the program....");

        }
    }

    private void askToGoBack() {
        System.out.print("Do you want to go back to the main menu (Yes/No)? ");
        String goBackToMenu = scanner.nextLine();
        if (goBackToMenu.equalsIgnoreCase("No")) {
            System.out.println("Exiting the program.");
            System.exit(0);
        }
    }

}
