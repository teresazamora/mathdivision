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
    public void NegativeDividendPositiveQuotient() {
        
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("_90|14").append("\n");
        expectedResult.append(" 84|-").append("\n");
        expectedResult.append(" --|6").append("\n");
        expectedResult.append("  6");
        String actualResult = formatter.format(division.divide(-90, 14));

        assertEquals(expectedResult.toString(), actualResult);
    }

    @Test
    public void NegativeDividerPositiveQuotient() {
        
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("_90|14").append("\n");
        expectedResult.append(" 84|-").append("\n");
        expectedResult.append(" --|6").append("\n");
        expectedResult.append("  6");
        String actualResult = formatter.format(division.divide(90, -14));

        assertEquals(expectedResult.toString(), actualResult);
    }

    @Test
    public void DividendAndDivisorConsistOfOneDigig() {
        
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("_4|3").append("\n");
        expectedResult.append(" 3|-").append("\n");
        expectedResult.append(" -|1").append("\n");
        expectedResult.append(" 1");
        String actualResult = formatter.format(division.divide(4, 3));

        assertEquals(expectedResult.toString(), actualResult);
    }

    @Test
    public void DivisionWithoutReminder() {
        
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("_4|2").append("\n");
        expectedResult.append(" 4|-").append("\n");
        expectedResult.append(" -|2").append("\n");
        expectedResult.append(" 0");
        String actualResult = formatter.format(division.divide(4, 2));

        assertEquals(expectedResult.toString(), actualResult);
    }

    @Test
    public void DividendAndDividerAreBigNumbers() {
        
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("_54823|47").append("\n");
        expectedResult.append(" 47   |----").append("\n");
        expectedResult.append(" --   |1166").append("\n");
        expectedResult.append(" _78").append("\n");
        expectedResult.append("  47").append("\n");
        expectedResult.append("  --").append("\n");
        expectedResult.append(" _312").append("\n");
        expectedResult.append("  282").append("\n");
        expectedResult.append("  ---").append("\n");
        expectedResult.append("  _303").append("\n");
        expectedResult.append("   282").append("\n");
        expectedResult.append("   ---").append("\n");
        expectedResult.append("     21");
        String actualResult = formatter.format(division.divide(54823, 47));

        assertEquals(expectedResult.toString(), actualResult);
    }
}
