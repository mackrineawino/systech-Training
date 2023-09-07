package com.systechtraining.restaurant;

import java.util.Scanner;

public class restaurant {
    public static void main(String[] args) {

         Scanner scanner = new Scanner(System.in);


        final String DB_USERNAME = "Root";
        final String DB_PASSWORD = "Admin123";

        int loginAttempts = 0;
        boolean authorized = false;

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

        if (authorized){

        } else {
            System.err.println("You have exhausted your login attempts. Please try again after a few minutes.");
        }

    }
}
