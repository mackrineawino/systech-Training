package com.systechtraining.operators;
import java.util.logging.Logger;

public class Operators {

    private static final Logger LOGGER = Logger.getLogger(Operators.class.getName());

    public void arithmeticOperators() {

        int studentOneAge = 22;
        int studentTwoAge = 19;

        // Addition operator
        int totalClassAge = studentOneAge + studentTwoAge;
        LOGGER.info("Total class Age: " + totalClassAge);

        // subtraction
        int ageDifference = studentOneAge - studentTwoAge;
        LOGGER.info("Age difference: " + ageDifference);

        // product of class ages => multiplication
        int ageProduct = studentOneAge * studentTwoAge;
        LOGGER.info("Age product: " + ageProduct);

        // division operator
        // ? division between integers result to an integer value otherwise double value
        int divisionResult = studentOneAge / studentTwoAge;
        LOGGER.info("Division: " + divisionResult);

        // ! To ensure correct values with precision
        double divisionResultInDouble = (double) studentOneAge / studentTwoAge;
        LOGGER.info("Division with precision: " + divisionResultInDouble);

        // modulus operator => remainder of division result
        int remainder = studentOneAge % studentTwoAge;
        LOGGER.info("Remainder: " + remainder);

    }

    public void assignmentOperators() {
        // simple assignment operator
        int quantity = 35;

        // addition assignment operator
        quantity += 10; // > quantity = quantity + 10;
        LOGGER.info("Quantity: " + quantity);

        // multiplication assignment operator
        quantity *= 100; // > quantity = quantity * 100;
        LOGGER.info("Quantity: " + quantity);
        // multiplication assignment operator
        quantity /= 20; // > quantity = quantity / 20;
        LOGGER.info("Quantity: " + quantity);
        
        // modulus assignment operator
        quantity %= 7; // > quantity = quantity / 7;
        LOGGER.info("Quantity: " + quantity);


    }

    public void comparisonOperators() {
        int studentOneAge = 20;
        int studentTwoAge = 25;

        // equality operator
        boolean isStudentOneAgeEqualToStudentTwoAge = studentOneAge == studentTwoAge;
        LOGGER.info("isStudentOneAgeEqualToStudentTwoAge: " + isStudentOneAgeEqualToStudentTwoAge);

        // Inequality operator
        boolean isStudentOneAgeNotEqualToStudentTwoAge = studentOneAge != studentTwoAge;
        LOGGER.info("isStudentOneAgeNotEqualToStudentTwoAge: " + isStudentOneAgeNotEqualToStudentTwoAge);

        // less than operator
        boolean isStudentOneAgeLessThanStudentTwoAge = studentOneAge < studentTwoAge;
        LOGGER.info("isStudentOneAgeLessThanStudentTwoAge: " + isStudentOneAgeLessThanStudentTwoAge);

        // greater than operator
        boolean isStudentOneAgeGreaterThanStudentTwoAge = studentOneAge > studentTwoAge;
        LOGGER.info("isStudentOneAgeGreaterThanStudentTwoAge: " + isStudentOneAgeGreaterThanStudentTwoAge);

        // Do one for less than or equal to operator
        boolean isStudentOneAgeLessThanOrEqualToStudentTwoAge = studentOneAge <= studentTwoAge;
        LOGGER.info("isStudentOneAgeLessThanOrEqualToStudentTwoAge: " + isStudentOneAgeLessThanOrEqualToStudentTwoAge);

        // Do one for greater than or equal to operator
        boolean isStudentOneAgeGreaterThanOrEqualToStudentTwoAge = studentOneAge >= studentTwoAge;
        LOGGER.info("isStudentOneAgeGreaterThanOrEqualToStudentTwoAge: " + isStudentOneAgeGreaterThanOrEqualToStudentTwoAge);
    }

    public static void main(String[] args) {
        Operators app = new Operators();
        app.arithmeticOperators();
        app.assignmentOperators();
        app.comparisonOperators();
    }

}
