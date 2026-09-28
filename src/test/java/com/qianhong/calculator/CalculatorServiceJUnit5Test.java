package com.qianhong.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CalculatorServiceJUnit5Test {

    @Test
    void addWorksWithNegativeNumbers() {
        CalculatorService calculator = new CalculatorService();

        assertEquals(3, calculator.Add(-5, 8).getResult());
    }

    @Test
    void divideReturnsWholeNumberQuotient() {
        CalculatorService calculator = new CalculatorService();

        assertEquals(4, calculator.Div(20, 5).getResult());
    }

    @Test
public void testPing() {
    assertTrue(new CalculatorService().ping()
            .contains("Welcome to Java Maven Calculator Web App!!!"));
}

@Test
public void testSub() {
    assertEquals(4, new CalculatorService().Sub(12, 8).getResult());
}

@Test
public void testMul() {
    assertEquals(88, new CalculatorService().Mul(11, 8).getResult());
}
}

