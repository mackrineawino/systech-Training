package com.systechtraining;

import java.util.logging.Logger;

public class App 
{
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main( String[] args )
    {
        
        int sum = addNumbers(5, 8);
        int difference = subtractNumbers(5, 8);

        LOGGER.info("The sum of the numbers is: "+ sum);
        LOGGER.info("The Diffence of the numbers is: "+ difference);

    }
    public static int addNumbers(int a, int b)
    {
        return a+b;
    } 
    public static int subtractNumbers(int c, int d)
    {
        return c-d;

    }
}