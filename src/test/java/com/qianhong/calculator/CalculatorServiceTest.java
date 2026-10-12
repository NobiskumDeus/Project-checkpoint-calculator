package com.qianhong.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Refactored legacy smoke tests using JUnit 5 assertions and conventions. */
class CalculatorServiceTest {

    @Test
    @DisplayName("Ping includes the application greeting")
    void pingIncludesApplicationGreeting() {
        assertTrue(new CalculatorService().ping()
                .contains("Welcome to Java Maven Calculator Web App!!!"));
    }

    @Test
    @DisplayName("Addition returns the sum")
    void addReturnsSum() {
        assertEquals(34, new CalculatorService().Add(8, 26).getResult());
    }

    @Test
    @DisplayName("Subtraction returns the difference")
    void subtractReturnsDifference() {
        assertEquals(4, new CalculatorService().Sub(12, 8).getResult());
    }

    @Test
    @DisplayName("Multiplication returns the product")
    void multiplyReturnsProduct() {
        assertEquals(88, new CalculatorService().Mul(11, 8).getResult());
    }

    @Test
    @DisplayName("Division returns the quotient")
    void divideReturnsQuotient() {
        assertEquals(1, new CalculatorService().Div(12, 12).getResult());
    }
}
