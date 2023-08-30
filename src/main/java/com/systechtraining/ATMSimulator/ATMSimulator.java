package com.systechtraining.ATMSimulator;
import java.util.Scanner;


public class ATMSimulator {
    
   public static void main(String[] args) {

 // constants declarations
    final String DB_USERNAME = "Root";
    final String DB_PASSWORD = "Admin123";

 // varriable declaration
    double balance = 1000;
    
 // Initialize the scanner class for user inputs
    Scanner scanner = new Scanner(System.in); 

 // User prompted for Auth credentials
    System.out.print("Welcome Dear Customer. To Proceed, Please Enter Your Username: ");
    String username = scanner.nextLine();

    System.out.print("Please Enter Your Password For Authentication: ");
    String password = scanner.nextLine();


 // Start of If else statement
    if ( username.equals(DB_USERNAME) && password.equals(DB_PASSWORD)){

        boolean quit = false;

     //The while loop will enable you go back to the menu after a transcation without program termination
        while(!quit){

     // Start of the Main menu
        System.out.println("***************");
        System.out.println();
        System.out.println("ATM SIMULATOR");
        System.out.println();

     //Use escape character to enable display of ""
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

     //Use escape character to enable display of ""
        System.out.println("\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"");
        


        System.out.print("Please Choose Your Transaction: ");
        String transaction = scanner.nextLine();

     // End of the Main menu

     //use switch statement to enable the user pick diffent cases of the transactions
        switch (transaction) {
            case "1":
                System.out.println("Welcome "+ username);
                System.out.println("Your balance is Ksh: "+ balance);
                askToGoBack(scanner);
                break;

            case "2":
                 System.out.print("How much would you like to deposit: ");
                 int depositedAmount = scanner.nextInt();
                 scanner.nextLine(); 
                 balance = balance + depositedAmount;
                 System.out.println("Deposit is sucessful. Available balance is Ksh: "+ balance);
                 askToGoBack(scanner);
                break;

            case "3":
                System.out.print("How much would you like to Withdraw: ");
                int withdrawalAmount = scanner.nextInt();
                scanner.nextLine(); 
                if(withdrawalAmount > balance){
                    System.err.println("Failed: Not enough money in your account");
                    System.err.println("Your Available balance is: "+ balance);
                    askToGoBack(scanner);
                }else{
                    double withdrawalTax = (2.0 / 100) * withdrawalAmount;
                    balance = (balance - (withdrawalAmount + withdrawalTax));
                    System.out.println("Withdrawal is successful. Available balance is: "+ balance);
                    askToGoBack(scanner);
                }
                break;

            case "4":
                System.out.print("How much would you like to transfer: ");
                int transferAmount = scanner.nextInt();
                scanner.nextLine(); 
                if(transferAmount > balance){
                    System.err.println("Failed: Not enough money in your account");
                    System.err.println("Your Available balance is: "+ balance);
                    askToGoBack(scanner);
                }else{
                    balance = balance - transferAmount;
                    System.out.println("Cash transfered  successfully. Available balance is: "+ balance);
                    askToGoBack(scanner);
                }
                break; 

            case "5":
                System.out.print("Are you sure you want to exit (Yes/No)? ");
                String exitPrompt = scanner.nextLine();
                if (exitPrompt.equalsIgnoreCase("Yes")) {
                    System.out.println("Exiting the program....");
                    quit = true;
                }
                break;

            default:
                System.err.println("Please input a valid transcation ID");
                break;
        }
    }

    }
    else{
        System.err.println("You have entered an incorrect Username or Password");
    }

 //End of If else statement

    scanner.close();

   } 
   //Implement this function to enable the user choose if they want to go back to the main menu or exit: this prevents default navigation to the meinmenu after eah transcation
   //Call the function after every trascation
    private static void askToGoBack(Scanner scanner) {
        System.out.print("Do you want to go back to the main menu (Yes/No)? ");
        String goBackToMenu = scanner.nextLine();
        if (goBackToMenu.equalsIgnoreCase("No")) {
        System.out.println("Exiting the program.");
        System.exit(0);
      }
}

}
