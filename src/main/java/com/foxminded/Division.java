package com.foxminded;

import java.util.ArrayList;
import java.util.List;

public class Division {

    public DivisionResult divide(int dividend, int divider) {

        List<DivisionStep> steps = new ArrayList<>();

        DivisionResult divisionResult = new DivisionResult();

        dividend = Math.abs(dividend);
        divider = Math.abs(divider);

        if (divider == 0) {
            throw new IllegalArgumentException("Divisor can't be 0, division by zero, try again");
        }
        if (dividend < divider) {
            throw new IllegalArgumentException("Divider can't be more than dividend, try again");
        }

        StringBuilder reminder = new StringBuilder();

        divisionResult.setQuotient(dividend / divider);
        divisionResult.setDividend(dividend);
        divisionResult.setDivider(divider);
        divisionResult.addSteps(steps);
        divisionResult.setReminder(dividend % divider);

        String[] digitsOfDividend = String.valueOf(dividend).split("");
        for (int i = 0; i < digitsOfDividend.length; i++) {
            reminder.append(digitsOfDividend[i]);
            int interimReminder = Integer.parseInt(reminder.toString());

            if (interimReminder >= divider) {
                int mod = interimReminder % divider;
                int multiplicationResult = interimReminder / divider * divider;

                int minuend = interimReminder;
                int subtrahend = multiplicationResult;

                DivisionStep step = new DivisionStep();

                step.setMinuend(minuend);
                step.setSubtrahend(subtrahend);

                steps.add(step);

                reminder.replace(0, reminder.length(), String.valueOf(mod));

                interimReminder = Integer.parseInt(reminder.toString());
            }

            if (i == digitsOfDividend.length - 1) {

                int minuend = interimReminder;

                DivisionStep step = new DivisionStep();

                step.setMinuend(minuend);
                steps.add(step);

            }
        }
        return divisionResult;
    }
}
