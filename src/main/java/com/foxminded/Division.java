package com.foxminded;

public class Division {

    public DivisionResult divide(int dividend, int divider) {

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

        String[] digitsOfDividend = String.valueOf(dividend).split("");
        for (int i = 0; i < digitsOfDividend.length; i++) {
            reminder.append(digitsOfDividend[i]);
            int interimReminder = Integer.parseInt(reminder.toString());

            if (interimReminder >= divider) {
                int mod = interimReminder % divider;
                int multiplicationResult = interimReminder / divider * divider;

                divisionResult.setMinuend(String.valueOf(interimReminder));
                divisionResult.setSubtrahend(String.valueOf(multiplicationResult));

                reminder.replace(0, reminder.length(), String.valueOf(mod));
                interimReminder = Integer.parseInt(reminder.toString());
            }
            if (i == digitsOfDividend.length - 1) {
                divisionResult.setMinuend(String.valueOf(interimReminder));
            }
        }
        return divisionResult;
    }
}
