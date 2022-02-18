package com.foxminded;

import java.util.List;

public class DivisionResult {

    private int dividend;
    private int divider;
    private int reminder;
    private List<DivisionStep> steps;
    private int quotient;

    public int getDividend() {
        return dividend;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getReminder() {
        return reminder;
    }

    public void setReminder(int reminder) {
        this.reminder = reminder;
    }

    public int getDivider() {
        return divider;
    }

    public void setDivider(int divider) {
        this.divider = divider;
    }

    public List<DivisionStep> getSteps() {
        return steps;
    }

    public void addSteps(List<DivisionStep> steps) {
        this.steps = steps;
    }

    public int getQuotient() {
        return quotient;
    }

    public void setQuotient(int quotient) {
        this.quotient = quotient;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DivisionResult other = (DivisionResult) obj;
        if (dividend != other.dividend)
            return false;
        if (divider != other.divider)
            return false;

        if (quotient != other.quotient)
            return false;

        if (reminder != other.reminder)
            return false;

        if (dividend < divider)
            return false;

        return true;
    }
}
