package com.foxminded;

public class DivisionFormatter {

    public String format(DivisionResult result) {

        String dividend = String.valueOf(result.getDividend());
        String divider = String.valueOf(result.getDivider());

        StringBuilder resultString = new StringBuilder();

        resultString.append(getFirstLine(dividend, divider));
        resultString.append(getSecondLine(dividend, result));
        resultString.append(getThirdLine(dividend, result));

        int j = result.getMinuend().get(0).length();
        for (int i = 1; i < result.getMinuend().size() - 1; i++) {

            String minuendLine = result.getMinuend().get(i);
            String subtrahendLine = result.getSubtrahend().get(i);

            resultString.append(String.format("%" + (j + 3) + "s", "_" + minuendLine + "\n"));
            resultString.append(String.format("%" + (j + 2) + "s", subtrahendLine) + "\n");
            resultString
                    .append(String.format("%" + (j + 2) + "s", repeatCharacter('-', subtrahendLine.length())) + "\n");
            j++;
        }

        resultString.append(getLastSubtrahen(dividend, result));

        return resultString.toString();
    }

    private String repeatCharacter(char character, int times) {

        StringBuilder resulting = new StringBuilder();
        for (int i = 0; i < times; i++) {
            resulting.append(character);
        }
        return resulting.toString();
    }

    private StringBuilder getFirstLine(String dividend, String divisor) {

        StringBuilder firstLine = new StringBuilder();

        firstLine.insert(0, "_" + dividend + "|" + divisor + "\n");

        return firstLine;
    }

    private StringBuilder getSecondLine(String dividend, DivisionResult result) {

        StringBuilder secondLine = new StringBuilder();
        String firstSubtrahend = result.getSubtrahend().get(0);
        int calculateDigit = dividend.length() - firstSubtrahend.length();

        secondLine.insert(0, " " + firstSubtrahend + repeatCharacter(' ', calculateDigit) + "|"
                + repeatCharacter('-', result.getQuotient().length()) + "\n");

        return secondLine;
    }

    private StringBuilder getThirdLine(String dividend, DivisionResult result) {

        StringBuilder thirdLine = new StringBuilder();
        int firstMinuend = result.getMinuend().get(0).length();
        int calculateDigit = dividend.length() - result.getMinuend().get(0).length();

        thirdLine.insert(0, " " + repeatCharacter('-', firstMinuend) + repeatCharacter(' ', calculateDigit) + "|"
                + result.getQuotient() + "\n");

        return thirdLine;
    }

    private StringBuilder getLastSubtrahen(String dividend, DivisionResult result) {

        StringBuilder lastSubtrahen = new StringBuilder();
        lastSubtrahen.insert(0,
                repeatCharacter(' ', dividend.length()) + result.getMinuend().get(result.getMinuend().size() - 1));

        return lastSubtrahen;
    }

}
