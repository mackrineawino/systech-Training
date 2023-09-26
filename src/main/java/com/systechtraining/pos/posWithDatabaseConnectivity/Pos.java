package com.systechtraining.pos.posWithDatabaseConnectivity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Pos {
    private static final Logger LOGGER = Logger.getLogger(Pos.class.getName());
    static Scanner scanner = new Scanner(System.in);
    private static Connection connection;
    private static Statement statement;
    static PreparedStatement preparedStatement;
    private Item fetchedItem;
    private static ResultSet resultSet;
    private int option;
    private static double paymentAmount;
    private static boolean keepShowingMenu = true;
    static boolean authorized = false;

    public static void main(String[] args) {

        FileHandler fileHandler;
        try {
            Pos pos = new Pos();
            fileHandler = new FileHandler("pos_Logging.txt");
            CustomFormatter formatter = new CustomFormatter();
            LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(formatter);
            pos.dbConnection();
            pos.login();
            if (authorized) {

                while (keepShowingMenu) {
                    pos.displayMenu();
                    pos.controlStatement();

                }

            } else {
                LOGGER.severe("You have exhausted your login attempts. Please try again after a few minutes.");
            }
            scanner.close();
            resultSet.close();
            preparedStatement.close();
            statement.close();
            connection.close();

        } catch (SecurityException e) {
            LOGGER.severe("Unable to obtain security permissions for the log file: " + e.getMessage());
        } catch (IOException e) {
            LOGGER.severe("Unable to obtain read/write permissions for the log file: " + e.getMessage());
        } catch (SQLException e) {
            LOGGER.severe("Database operation failure: " + e.getMessage());
        }

    }

    public void controlStatement() {

        System.out.println("Please chose an option: ");
        option = scanner.nextInt();
        switch (option) {
            case 1:
                addItems();

                break;

            case 2:
                makePayment();

                break;

            case 3:
                printReciept();
                break;

            case 4:
                keepShowingMenu = false;
                LOGGER.warning("Exiting the program\n");
                System.exit(0);
                break;

            default:
                LOGGER.severe("Please enter a valid option\n");
                break;
        }

    }

    public void dbConnection() {
        try {
            Class.forName("org.postgresql.Driver");

            String connectionUrl = "jdbc:postgresql://localhost:5432/javase";
            String user = "test1";
            String password = "test1";
            connection = DriverManager.getConnection(connectionUrl, user, password);

            statement = connection.createStatement();
            String createItemsTable = "CREATE TABLE IF NOT EXISTS items (itemCode VARCHAR(255) PRIMARY KEY, quantity INT, unitPrice DOUBLE PRECISION, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
            statement.executeUpdate(createItemsTable);

            String createAuthTable = "CREATE TABLE IF NOT EXISTS auth (user_id SERIAL PRIMARY KEY, userName VARCHAR(255), password VARCHAR(255), created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
            statement.executeUpdate(createAuthTable);

        } catch (ClassNotFoundException e) {
            LOGGER.severe("Unable to obtain class for jdbc driver: " + e.getMessage());
        } catch (SQLException e) {
            LOGGER.severe("Database operation failure: " + e.getMessage());
        }

    }

    public void login() {
        try {

            String selectQuery = "SELECT * from auth;";

            resultSet = statement.executeQuery(selectQuery);
            int loginAttempts = 0;
            while (resultSet.next()) {
                while (loginAttempts < 3) {

                    System.out.print(" Welcome Dear Customer. Please Enter Your Password For Authentication: ");
                    String userPassword = scanner.nextLine();

                    String storedPassword = resultSet.getString("password");

                    if (userPassword.equals(storedPassword)) {
                        authorized = true;
                        break;
                    } else {

                        loginAttempts++;
                        LOGGER.severe("Invalid password. Attempts remaining:\n " + (3 - loginAttempts));
                    }
                }

            }
        } catch (SQLException e) {
            LOGGER.severe("Database operation failure:\n " + e.getMessage());
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
        System.out.println("4. QUIT");
        System.out.println();
    }

    public void addItems() {
        boolean addMore = true;
        try {
            String insertQuery = "insert into items (itemCode, quantity, unitPrice)values(?,?,?);";
            preparedStatement = connection.prepareStatement(insertQuery);

            while (addMore) {
                System.out.print("Enter the item code: ");
                int itemCode = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter the Quantity of the item: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter the unit price: ");
                double unitPrice = scanner.nextDouble();
                scanner.nextLine();

                Item item = new Item(itemCode, quantity, unitPrice);

                preparedStatement.setInt(1, item.getItemCode());
                preparedStatement.setInt(2, item.getQuantity());
                preparedStatement.setDouble(3, item.getUnitPrice());
                preparedStatement.executeUpdate();
                System.out.println("Do you want to add another item? Y/N: ");

                String addMoreItems = scanner.nextLine();

                if (addMoreItems.equalsIgnoreCase("Y")) {
                    System.out.println("Proceed");
                } else {
                    addMore = false;

                }

            }
            makePayment();

        } catch (SQLException e) {
            LOGGER.severe("Duplicate key value violates unique constraint. Primary key must be unique\n");
        }
    }

    public void makePayment() {
        try {
            String selectQuery = "SELECT * from items;";

            resultSet = statement.executeQuery(selectQuery);
            if (resultSet != null) {
                double total = 0; // Initialize total outside the loop
                System.out.println("Item Code   Quantity   Unit Price   Total Value");

                while (resultSet.next()) {
                    int itemCode = resultSet.getInt("itemCode");
                    int quantity = resultSet.getInt("quantity");
                    double unitPrice = resultSet.getDouble("unitPrice");

                    // map to object
                    fetchedItem = new Item(itemCode, quantity, unitPrice);
                    double itemTotal = quantity * unitPrice;

                    // Accumulate the total for all items
                    total += itemTotal;

                    System.out.printf("%-12d%-11d%-12.2f%-13.2f%n", fetchedItem.getItemCode(),
                            fetchedItem.getQuantity(), fetchedItem.getUnitPrice(), itemTotal);
                }

                System.out.println();
                System.out.println("************************************************");
                System.out.println("Total: " + total);
                System.out.println("************************************************");

                System.out.print("Enter the amount given by customer: ");
                paymentAmount = scanner.nextInt();
                if (paymentAmount >= total) {

                    double change = paymentAmount - total;

                    System.out.println("Change: " + change);
                    System.out.println("_____");
                    System.out.println("************************************************");
                    System.out.println("THANK YOU FOR SHOPPING WITH US!");
                    System.out.println("************************************************");
                } else {
                    LOGGER.severe("Insufficient Funds!\n");
                    displayMenu();
                }
            } else {
                LOGGER.warning("Add items to the cart first");
                displayMenu();
            }

        } catch (ArithmeticException e) {
            LOGGER.severe(e.getMessage());
        } catch (SQLException e) {
            LOGGER.severe("Database operation failure:\n " + e.getMessage());
        }

    }

    public void printReciept() {
        try {
            String selectQuery = "SELECT * from items;";

            resultSet = statement.executeQuery(selectQuery);

            // Check if there are records in the result set
            if (!resultSet.isBeforeFirst()) {
                LOGGER.warning("Cart is empty...Please add items:");
                displayMenu(); // Exit the method if there are no records
            }

            System.out.println("Item Code   Quantity   Unit Price   Total Value");
            double receiptTotal = 0.0;

            while (resultSet.next()) {
                int itemCode = resultSet.getInt("itemCode");
                int quantity = resultSet.getInt("quantity");
                double unitPrice = resultSet.getDouble("unitPrice");

                Item fetchedItem = new Item(itemCode, quantity, unitPrice);
                double itemTotal = quantity * unitPrice;

                System.out.printf("%-12d%-11d%-12.2f%-13.2f%n",
                        fetchedItem.getItemCode(),
                        fetchedItem.getQuantity(),
                        fetchedItem.getUnitPrice(),
                        itemTotal);

                receiptTotal += itemTotal;
            }
            if (paymentAmount >= receiptTotal) {
                double change = paymentAmount - receiptTotal;

                System.out.println();
                System.out.println("************************************************");
                System.out.println("Total: " + receiptTotal);
                System.out.println("************************************************");
                System.out.println("Payment Amount: " + paymentAmount);
                System.out.println("Change: " + change);
                System.out.println("_____");
                System.out.println("************************************************");
                System.out.println("THANK YOU FOR SHOPPING WITH US!");
                System.out.println("************************************************");
            }

            else {
                System.out.println();
                System.out.println("************************************************");
                System.out.println("Total: " + receiptTotal);
                System.out.println("************************************************");
                System.out.println("Payment Amount: " + paymentAmount);
                LOGGER.severe("No change: Insufficient Funds provided!\n");

            }

        } catch (SQLException e) {
            LOGGER.severe("Database operation failure:\n " + e.getMessage());
        }
    }

}