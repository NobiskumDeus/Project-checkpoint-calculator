package com.qianhong.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Black-box, boundary-value, equivalence-partition, and path-oriented tests. */
class CalculatorServiceJUnit5Test {

    private final CalculatorService calculator = new CalculatorService();

    @Test
    @DisplayName("Black-box: ping returns the expected greeting")
    void pingReturnsGreeting() {
        assertTrue(calculator.ping().contains("Welcome to Java Maven Calculator Web App!!!"));
    }

    @Test
    @DisplayName("Equivalence partition: addition with positive operands")
    void addPositiveNumbers() {
        assertEquals(34, calculator.Add(8, 26).getResult());
    }

    @Test
    @DisplayName("Equivalence partition: addition with a negative operand")
    void addNegativeNumber() {
        assertEquals(3, calculator.Add(-5, 8).getResult());
    }

    @Test
    @DisplayName("Boundary: adding zero leaves the value unchanged")
    void addZero() {
        assertEquals(42, calculator.Add(42, 0).getResult());
    }

    @Test
    @DisplayName("Boundary: Java int addition overflow is defined consistently")
    void addAtIntegerMaximumBoundary() {
        assertEquals(Integer.MIN_VALUE, calculator.Add(Integer.MAX_VALUE, 1).getResult());
    }

    @Test
    @DisplayName("Black-box: subtraction returns the difference")
    void subtractsPositiveNumbers() {
        assertEquals(4, calculator.Sub(12, 8).getResult());
    }

    @Test
    @DisplayName("Equivalence partition: subtraction can produce a negative result")
    void subtractionProducesNegativeResult() {
        assertEquals(-7, calculator.Sub(3, 10).getResult());
    }

    @Test
    @DisplayName("Boundary: subtracting zero leaves the value unchanged")
    void subtractZero() {
        assertEquals(-9, calculator.Sub(-9, 0).getResult());
    }

    @Test
    @DisplayName("Boundary: Java int subtraction overflow is defined consistently")
    void subtractAtIntegerMinimumBoundary() {
        assertEquals(Integer.MAX_VALUE, calculator.Sub(Integer.MIN_VALUE, 1).getResult());
    }

    @Test
    @DisplayName("Black-box: multiplication returns the product")
    void multipliesPositiveNumbers() {
        assertEquals(88, calculator.Mul(11, 8).getResult());
    }

    @Test
    @DisplayName("Equivalence partition: multiplying by zero returns zero")
    void multiplyByZero() {
        assertEquals(0, calculator.Mul(999, 0).getResult());
    }

    @Test
    @DisplayName("Equivalence partition: multiplying a positive and negative operand")
    void multiplyPositiveAndNegativeNumbers() {
        assertEquals(-24, calculator.Mul(6, -4).getResult());
    }

    @Test
    @DisplayName("Boundary: Java int multiplication overflow is defined consistently")
    void multiplyAtIntegerBoundary() {
        assertEquals(-2, calculator.Mul(Integer.MAX_VALUE, 2).getResult());
    }

    @Test
    @DisplayName("Black-box: division returns an exact quotient")
    void dividesExactly() {
        assertEquals(4, calculator.Div(20, 5).getResult());
    }

    @Test
    @DisplayName("Equivalence partition: integer division truncates the fractional part")
    void divisionTruncatesFractionalPart() {
        assertEquals(2, calculator.Div(7, 3).getResult());
    }

    @Test
    @DisplayName("Equivalence partition: division supports negative operands")
    void dividesNegativeNumber() {
        assertEquals(-4, calculator.Div(-20, 5).getResult());
    }

    @Test
    @DisplayName("Boundary: zero numerator produces zero for nonzero denominator")
    void zeroNumerator() {
        assertEquals(0, calculator.Div(0, 7).getResult());
    }

    @Test
    @DisplayName("Exceptional path: division by zero throws ArithmeticException")
    void divisionByZeroThrows() {
        assertThrows(ArithmeticException.class, () -> calculator.Div(10, 0));
    }

    @Test
    @DisplayName("Boundary: Java int division overflow is defined consistently")
    void divisionAtIntegerBoundary() {
        assertEquals(Integer.MIN_VALUE, calculator.Div(Integer.MIN_VALUE, -1).getResult());
    }

    @Test
    @DisplayName("Path-oriented: each arithmetic method returns its response object")
    void arithmeticMethodsReturnResponses() {
        assertEquals(7, calculator.Add(3, 4).getResult());
        assertEquals(-1, calculator.Sub(3, 4).getResult());
        assertEquals(12, calculator.Mul(3, 4).getResult());
        assertEquals(3, calculator.Div(12, 4).getResult());
    }
}
