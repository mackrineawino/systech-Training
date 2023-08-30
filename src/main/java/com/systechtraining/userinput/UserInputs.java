package com.systechtraining.userinput;
import java.util.logging.Logger;
import java.util.Scanner;

public class UserInputs {
    private static final Logger LOGGER = Logger.getLogger(UserInputs.class.getName());



    public static void main(String[] args) {
        final String DB_USERNAME = "Awino";
        final String DB_PASSWORD = "Sudo@86";

        Scanner scanner = new Scanner(System.in); 

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if ( username.equals(DB_USERNAME) && password.equals(DB_PASSWORD)){
            System.out.println("Welcome to our website");
        }
        else{
            System.err.println("Incorrect username or password");
        }

        scanner.close();






    }
}
