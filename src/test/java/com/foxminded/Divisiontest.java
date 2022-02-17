package com.foxminded;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Divisiontest {

   Division division;
   

    @BeforeEach
    void setUp() {
        division = new Division();
    }


    @Test
    public void givenZeroDivisor_whenDivide_thenIllegalArgumentExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            division.divide(2, 0);
        });
    }

    @Test
    public void givenDividerGraterThanDividend_whenDivide_thenIllegalArgumentExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            division.divide(2, 4);
        });
    }

    @Test
    public void giverTwoNumbersWithoutReminder_whenDivide_thenTheLastMinuendWillBeZero() {
        DivisionResult expected = new DivisionResult();
        List<DivisionStep> steps = new ArrayList<>();
        DivisionStep step = new DivisionStep();
        step.setMinuend(25);
        step.setSubtrahend(25);
        steps.add(step);

        expected.setDividend(25);
        expected.setDivider(5);
        expected.setQuotient(5);
        expected.addSteps(steps);
        expected.setReminder(0);

        DivisionResult actual = division.divide(25, 5);

        assertEquals(expected, actual);
    }

    @Test
    public void givenNegativeDividend_whenDivide_thenItWillBeTrasformInPositive() {
        DivisionResult expected = new DivisionResult();
        DivisionStep step = new DivisionStep();
        List<DivisionStep> steps = new ArrayList<>();

        step.setMinuend(21);
        step.setSubtrahend(21);
        steps.add(step);

        expected.setDividend(21);
        expected.setDivider(3);
        expected.setQuotient(7);
        expected.addSteps(steps);
        expected.setReminder(0);

        DivisionResult actual = division.divide(-21, 3);

        assertEquals(expected, actual);
    }

}
