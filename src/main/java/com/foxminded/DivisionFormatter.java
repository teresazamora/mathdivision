package com.foxminded;

import java.util.List;

public class DivisionFormatter {

	public String format(DivisionResult result) {
		String dividend = String.valueOf(result.getDividend());
		String divisor = String.valueOf(result.getDivider());

		List<DivisionStep> steps = result.getSteps();

		StringBuilder resultString = new StringBuilder();

		resultString.append(getFirstLine(dividend, divisor));
		resultString.append(getSecondLine(dividend, result, steps));
		resultString.append(getThirdLine(dividend, result, steps));

		int j = String.valueOf(steps.get(0).getMinuend()).length() + 1;
		for (int i = 1; i < steps.size() - 1; i++) {

			String minuendLine = String.valueOf(steps.get(i).getMinuend());
			String subtrahendLine = String.valueOf(steps.get(i).getSubtrahend());

			if (minuendLine.equals("0")) {
				j++;
			} else {
				resultString.append(String.format("%" + (j + 2) + "s",
						"_" + minuendLine + System.lineSeparator()));
				resultString.append(
						String.format("%" + (j + 1) + "s", subtrahendLine) + System.lineSeparator());
				resultString.append(String.format("%" + (j + 1) + "s",
						repeatCharracter('-', String.valueOf(subtrahendLine).length()))
						+ System.lineSeparator());
			}
			j++;
		}
		resultString.append(getLastLine(dividend, result));
		return resultString.toString();
	}

	private String repeatCharracter(char character, int times) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < times; i++) {
			result.append(character);
		}
		return result.toString();
	}

	private StringBuilder getFirstLine(String dividend, String divisor) {
		StringBuilder firstLine = new StringBuilder();
		firstLine.insert(0, "_" + dividend + "|" + divisor + System.lineSeparator());
		return firstLine;
	}

	private StringBuilder getSecondLine(String dividend, DivisionResult result, List<DivisionStep> steps) {
		StringBuilder secondLine = new StringBuilder();
		String firstSubtrahend = String.valueOf(steps.get(0).getSubtrahend());
		int calculateDigitsSubtrahend = dividend.length() - firstSubtrahend.length();

		secondLine.insert(0,
				" " + firstSubtrahend + repeatCharracter(' ', calculateDigitsSubtrahend) + "|"
						+ repeatCharracter('-', String.valueOf(result.getQuotient()).length())
						+ System.lineSeparator());

		return secondLine;
	}

	private StringBuilder getThirdLine(String dividend, DivisionResult result, List<DivisionStep> steps) {
		StringBuilder thirdLine = new StringBuilder();
		int firstMinuend = String.valueOf(steps.get(0).getMinuend()).length();
		int calculateDigitsMinuend = dividend.length() - firstMinuend;
		thirdLine.insert(0,
				" " + repeatCharracter('-', firstMinuend) + repeatCharracter(' ', calculateDigitsMinuend)
						+ "|" + result.getQuotient() + System.lineSeparator());
		return thirdLine;
	}

	private StringBuilder getLastLine(String dividend, DivisionResult result) {
		StringBuilder lastLine = new StringBuilder();
		int digitsInReminder = String.valueOf(result.getReminder()).length();
		int positionOfReminder = dividend.length() - digitsInReminder;
		lastLine.append(" " + repeatCharracter(' ', positionOfReminder) + String.valueOf(result.getReminder()));

		return lastLine;
	}
}