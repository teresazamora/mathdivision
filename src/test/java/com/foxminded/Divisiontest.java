package com.foxminded;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Divisiontest {

    Division division;

    @BeforeEach
    void setUp() {
        division = new Division();
    }

    @Test
    public void DivisorIsZeroThrowException() {

        assertThrows(IllegalArgumentException.class, () -> {
            division.divide(2, 0);
        });
    }

    @Test
    public void DividerIsMoreThaDividend_whenDivide_thenThrowException() {
        
        assertThrows(IllegalArgumentException.class, () -> {
            division.divide(2, 4);
        });
    }

    @Test
    public void DivisionWithoutReminderTheLastMinuendWillBeZero() {
        
        DivisionResult expected = new DivisionResult();
        expected.setDividend(25);
        expected.setDivider(5);
        expected.setQuotient(5);
        expected.setMinuend("25");
        expected.setSubtrahend("25");
        expected.setMinuend("0");
        DivisionResult actual = division.divide(25, 5);

        assertEquals(expected, actual);
    }

    @Test
    public void DivisionWithBigNumbers() {
        
        DivisionResult expected = new DivisionResult();
        expected.setDividend(54823);
        expected.setDivider(47);
        expected.setQuotient(1166);
        expected.setMinuend("54");
        expected.setSubtrahend("47");
        expected.setMinuend("78");
        expected.setSubtrahend("47");
        expected.setMinuend("312");
        expected.setSubtrahend("282");
        expected.setMinuend("303");
        expected.setSubtrahend("282");
        expected.setMinuend("21");
        DivisionResult actual = division.divide(54823, 47);

        assertEquals(expected, actual);
    }

    @Test
    public void DivisionWithNegativeDividendWillBeTrasformInPositive() {
        
        DivisionResult expected = new DivisionResult();
        expected.setDividend(21);
        expected.setDivider(3);
        expected.setQuotient(7);
        expected.setMinuend("21");
        expected.setSubtrahend("21");
        expected.setMinuend("0");
        DivisionResult actual = division.divide(-21, 3);

        assertEquals(expected, actual);
    }

}
