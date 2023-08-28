package com.systechtraining.loops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import com.systechtraining.loopingStatements.LoopingStatements;

public class LoopsTest {
    
      LoopingStatements app = new LoopingStatements();
    private static final Logger LOGGER = Logger.getLogger(LoopsTest.class.getName());

    @Test
    public void test_number_in_range_of_one_fifty(){
        int search   = app.search(10);
        LOGGER.info("search value: " + search);
        Assertions.assertEquals(10, search );
    }
}
