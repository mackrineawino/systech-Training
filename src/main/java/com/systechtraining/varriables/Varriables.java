package com.systechtraining.varriables;
import java.util.logging.Logger;

public class Varriables {
    private static final Logger LOGGER = Logger.getLogger(Varriables.class.getName());

    private void variableDeclarations() {
        // integer variable
        // ? type variableName
        int score = 0;
        LOGGER.info("Score integer variable value is " + score);
    }

    private void constantsVariables() {
        // ? constant variable
        // final type variableName = value;
        final double PI = 3.14159;
        LOGGER.info("Constant variable PI = " + PI);
    }

    private void integerTypes() {
        LOGGER.info("Integer Minimum " + Integer.MIN_VALUE);
        LOGGER.info("Integer Maximum " + Integer.MAX_VALUE);

        LOGGER.info("Long Minimum " + Long.MIN_VALUE);
        LOGGER.info("Long Maximum " + Long.MAX_VALUE);
        // byte, short, int, long
        //? Wrapper classes

        byte aPrimitive = 23;
        Byte aWrapper = 23;

        LOGGER.info("byte primitive " + aPrimitive);
        LOGGER.info("Byte wrapper " + aWrapper);

        int a = aWrapper.intValue();

        LOGGER.info("Integer value from Byte wrapper " + a );

        //short 
        short s = 23;
        Short sShort = 23;
        LOGGER.info("short primitive " + s);
        LOGGER.info("Short wrapper " + sShort);

        // integer 
        int c =23;
        Integer cInt = 23;
        LOGGER.info("integer primitive " + c);
        LOGGER.info("Integer wrapper " + cInt);

        // long 
        long d = 23;
        //! You need to explicitly suffix the Long wrapper with an L
        Long dLong = 23L;
        LOGGER.info("long primitive " + d);
        LOGGER.info("Long wrapper " + dLong);
       


    }

    private void floatingTypes() {
        // float type
        float floatRate = 2.1457454F;
        double doubleRate = 2.1457454;
        LOGGER.info("float value " + floatRate);
        LOGGER.info("double value " + doubleRate);

        //float
        float price = 0.2365F;
        Float priceFloat = 0.2365F;
        LOGGER.info("float primitive " + price);
        LOGGER.info("Float wrapper " + priceFloat);
        //double
        double prtPrice = 0.2365;
        Double priceDouble = 0.2365;
        LOGGER.info("double primitive " + prtPrice);
        LOGGER.info("double wrapper " + priceDouble);

    }

    private void characterTypes() {
        // character type
        char grade = 'A';
        LOGGER.info("character value " + grade);
        
        //character type
        Character characterGrade = 'F';
        LOGGER.info("Wrapper value " + characterGrade);

        

    }

    private void booleanTypes() {
        // boolean type
        boolean isPromoted = false;
        boolean isProcessed = true;

        LOGGER.info("false value " + isPromoted);
        LOGGER.info("true value " + isProcessed);

    }

    public static void main(String[] args) {
        Varriables demo = new Varriables();
        demo.variableDeclarations();
        demo.constantsVariables();
        demo.integerTypes();
        demo.floatingTypes();
        demo.characterTypes();
        demo.booleanTypes();

        long  a = 2147483648L;

        // int b = a.intValue();
        int c = (int) a;

        LOGGER.info("int  b value " + c);

    }

}
