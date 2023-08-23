package com.systechtraining;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator(); 

    @Test
    public void addNumbersTest(){
        int result = Calculator.addNumbers(3, 7);
        assertEquals(10, result);
    }

    @Test
    public void subtractNumbersTest()
    {
        int result = Calculator.subtractNumbers(10, 15);
        assertEquals(-5, result);
    }
    
}
