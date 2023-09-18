package com.systechtraining.static_classes_and_methods;

public class ATMUtils {
    public static String maskCardNumber(String cardNumber) {
        String mask = "XXXXXXXXXXXX";
        String postfix = cardNumber.substring(12, cardNumber.length());
        return mask + postfix;
    }
}
