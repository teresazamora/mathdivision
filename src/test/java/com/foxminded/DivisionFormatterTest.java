package com.foxminded;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DivisionFormatterTest {

    private Division division;
    private DivisionFormatter formatter;

    @BeforeEach
    private void setUp() {
        division = new Division();
        formatter = new DivisionFormatter();
    }

    @Test
    public void givenNegativeDividend_whenDivide_thenWIllBePositiveQuotient() {
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("_90|14").append(System.lineSeparator());
        expectedResult.append(" 84|-").append(System.lineSeparator());
        expectedResult.append(" --|6").append(System.lineSeparator());
        expectedResult.append("  6");
        String actualResult = formatter.format(division.divide(-90, 14));

        assertEquals(expectedResult.toString(), actualResult);
    }

    @Test
    public void givenNegativeDivider_whenDivide_thenWillBePositiveQuotient() {
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("_90|14").append(System.lineSeparator());
        expectedResult.append(" 84|-").append(System.lineSeparator());
        expectedResult.append(" --|6").append(System.lineSeparator());
        expectedResult.append("  6");
        String actualResult = formatter.format(division.divide(90, -14));

        assertEquals(expectedResult.toString(), actualResult);
    }

    @Test
    public void givenSmallNumbers_whenDivide_thenDivisionWillHaveFewSteps() {
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("_4|3").append(System.lineSeparator());
        expectedResult.append(" 3|-").append(System.lineSeparator());
        expectedResult.append(" -|1").append(System.lineSeparator());
        expectedResult.append(" 1");
        String actualResult = formatter.format(division.divide(4, 3));

        assertEquals(expectedResult.toString(), actualResult);
    }

    @Test
    public void givenTwoNumbersWithoutReminder_whenDivide_thenDivisionWithoutReminder() {
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("_4|2").append(System.lineSeparator());
        expectedResult.append(" 4|-").append(System.lineSeparator());
        expectedResult.append(" -|2").append(System.lineSeparator());
        expectedResult.append(" 0");
        String actualResult = formatter.format(division.divide(4, 2));

        assertEquals(expectedResult.toString(), actualResult);
    }

    @Test
    public void givenBigNumbers_whenDivide_thenDivisionWillHaveMoreSteps() {
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("_54823|47").append(System.lineSeparator());
        expectedResult.append(" 47   |----").append(System.lineSeparator());
        expectedResult.append(" --   |1166").append(System.lineSeparator());
        expectedResult.append(" _78").append(System.lineSeparator());
        expectedResult.append("  47").append(System.lineSeparator());
        expectedResult.append("  --").append(System.lineSeparator());
        expectedResult.append(" _312").append(System.lineSeparator());
        expectedResult.append("  282").append(System.lineSeparator());
        expectedResult.append("  ---").append(System.lineSeparator());
        expectedResult.append("  _303").append(System.lineSeparator());
        expectedResult.append("   282").append(System.lineSeparator());
        expectedResult.append("   ---").append(System.lineSeparator());
        expectedResult.append("    21");
        String actualResult = formatter.format(division.divide(54823, 47));

        assertEquals(expectedResult.toString(), actualResult);
    }

    @Test
    public void givenNumberWithManyZeroInTheMiddle_whenDivide_thenDivisionWillHaveMoreSteps() {
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("_10010010|10").append(System.lineSeparator());
        expectedResult.append(" 10      |-------").append(System.lineSeparator());
        expectedResult.append(" --      |1001001").append(System.lineSeparator());
        expectedResult.append("   _10").append(System.lineSeparator());
        expectedResult.append("    10").append(System.lineSeparator());
        expectedResult.append("    --").append(System.lineSeparator());
        expectedResult.append("      _10").append(System.lineSeparator());
        expectedResult.append("       10").append(System.lineSeparator());
        expectedResult.append("       --").append(System.lineSeparator());
        expectedResult.append("        0");
        String actualResult = formatter.format(division.divide(10010010, 10));

        assertEquals(expectedResult.toString(), actualResult);
    }
}
