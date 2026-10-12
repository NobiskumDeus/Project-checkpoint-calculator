package com.qianhong.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** White-box/data-flow tests for CalculatorResponse fields and accessors. */
class CalculatorResponseJUnit5Test {

    @Test
    @DisplayName("DU: constructor definitions of x, y, and result reach their getters")
    void constructorValuesReachAccessors() {
        CalculatorResponse response = new CalculatorResponse(7, 5, 12);

        assertEquals(7, response.getX());
        assertEquals(5, response.getY());
        assertEquals(12, response.getResult());
    }

    @Test
    @DisplayName("DU: time is defined by the constructor and read by getTime")
    void constructorDefinesReadableTimestamp() {
        CalculatorResponse response = new CalculatorResponse(1, 2, 3);

        assertNotNull(response.getTime());
        assertFalse(response.getTime().isEmpty());
    }

    @Test
    @DisplayName("Equivalence partition: response preserves negative and zero values")
    void responsePreservesNegativeAndZeroValues() {
        CalculatorResponse response = new CalculatorResponse(-8, 0, -8);

        assertEquals(-8, response.getX());
        assertEquals(0, response.getY());
        assertEquals(-8, response.getResult());
    }

    @Test
    @DisplayName("Boundary: response preserves integer extremes")
    void responsePreservesIntegerExtremes() {
        CalculatorResponse response = new CalculatorResponse(Integer.MIN_VALUE,
                Integer.MAX_VALUE, Integer.MIN_VALUE);

        assertEquals(Integer.MIN_VALUE, response.getX());
        assertEquals(Integer.MAX_VALUE, response.getY());
        assertEquals(Integer.MIN_VALUE, response.getResult());
    }
}
