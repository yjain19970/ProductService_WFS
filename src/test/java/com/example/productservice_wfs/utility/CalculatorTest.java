package com.example.productservice_wfs.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/***
 *
 * Arrange ---> setup
 *      Create : create objects / create inputs whatever is required.
 *      Call : call the objects.
 *      Check : finally verify.
 * Act --->
 *  call the behaviour that you want to test.
 * Assert
 *   finally verifying the output.
 *
 */


class CalculatorTest {


    /**
     * Testcases:
     * Happy - When sum is returned
     * Sad -   overflow
     * Exception: when number is pased as null
     */
    @Test
    @DisplayName("Adding two numbers when input is correct")
    void addWhenNumbersArePassed() {
        // Arrange
        Calculator c = new Calculator();
        // Act
        int result = c.add(1, 2);
        //Assert
        assertEquals(3, result);

    }

    @Test
    void addWhenNumberPassedAreOutOfRange() {

        // ToDo: Add this test case.
    }

    @Test
    void addWhenNumberPassedIsNull() {
        // Arrange
        Calculator c = new Calculator();
        // Act
        assertThrows(NullPointerException.class, () -> c.add(1, null));

    }


    @Test
    void testAdd() {
    }
}

/**
 * Homework:
 * 1. Complete all the test cases mentioned here and also add some test cases for
 * divide method.
 */