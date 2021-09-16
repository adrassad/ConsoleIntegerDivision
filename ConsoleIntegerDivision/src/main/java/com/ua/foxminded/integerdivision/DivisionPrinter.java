package com.ua.foxminded.integerdivision;

import java.util.List;

public class DivisionPrinter {

  public void print(DivisionSteps steps) {
    System.out.print(formatDivisionSteps(steps));
  }

  String formatDivisionSteps(DivisionSteps steps) {
    List<DivisionStep> listSteps = steps.getListSteps();
    StringBuilder result = new StringBuilder();
    int shift = 0;
    for (int i = 0; listSteps.size() > i; i++) {
      DivisionStep step = listSteps.get(i);
      if (i == 0) {
        result.append(formatFirstStep(steps));
        shift = calculateShift(step, shift);
      } else {
        result.append(formatMinuend(step, shift));
        result.append(formatSubtrahend(step, shift));
        result.append(formatDelimiterOfSubtraction(step, shift));
        shift = calculateShift(step, shift);
      }
    }
    result.append(formatDifferenceDivision(steps));
    return result.toString().trim();
  }

  private String formatFirstStep(DivisionSteps steps) {
    int dividend = steps.getDividend();
    int divisor = steps.getDivisor();
    int quotient = steps.getQuotient();
    DivisionStep step = steps.getListSteps().get(0);
    StringBuilder result = new StringBuilder();
    String shiftToQuotient = formatShiftToQuotient(dividend, step);
    result.append(formatDividend(dividend) + formatDivisor(divisor));
    result.append(formatSubtrahend(step, 0) + shiftToQuotient);
    result.append(formatDelimiterOfDivision(divisor, quotient));
    result.append(formatDelimiterOfSubtraction(step, 0) + shiftToQuotient + formatQuotient(quotient));
    return result.toString();
  }

  private String formatDivisor(int divisor) {
    return "|" + divisor;
  }

  private String formatDividend(int dividend) {
    return "_" + dividend;
  }

  private String formatSubtrahend(DivisionStep step, int shift) {
    String result = "";
    int minuend = step.getMinuend();
    int subtrahend = step.getSubtrahend();
    if (subtrahend == 0) {
      return result;
    } else {
      result = FormatterUtils.repeat(' ', FormatterUtils.calculateLengthDifference(minuend, subtrahend) + shift + 1)
          + subtrahend;
    }
    return "\n" + result;
  }

  private String formatDelimiterOfSubtraction(DivisionStep step, int shift) {
    String result = "";
    int minuend = step.getMinuend();
    int subtrahend = step.getSubtrahend();
    if (subtrahend == 0) {
      return result;
    } else {
      result = FormatterUtils.repeat(' ', FormatterUtils.calculateLengthDifference(minuend, subtrahend) + shift + 1)
          + FormatterUtils.repeat('-', FormatterUtils.length(subtrahend));
    }
    return "\n" + result;
  }

  private String formatDelimiterOfDivision(int divisor, int quotient) {
    return "|" + FormatterUtils.repeat('-', FormatterUtils.length(Integer.max(divisor, quotient)));
  }

  private String formatQuotient(int quotient) {
    return "|" + quotient;
  }

  private String formatShiftToQuotient(int dividend, DivisionStep step) {
    return FormatterUtils.repeat(' ', FormatterUtils.calculateLengthDifference(dividend, step.getMinuend()));
  }

  private String formatMinuend(DivisionStep step, int shift) {
    int minuend = step.getMinuend();
    if (minuend == 0) {
      return "";
    }
    return "\n" + FormatterUtils.repeat(' ', shift) + "_" + minuend;
  }

  private int calculateShift(DivisionStep step, int shift) {
    int minuend = step.getMinuend();
    int difference = step.getDifference();
    if (minuend == 0) {
      return shift;
    } else if (difference == 0) {
      return FormatterUtils.length(minuend);
    }
    return shift + FormatterUtils.calculateLengthDifference(minuend, difference);
  }

  private String formatDifferenceDivision(DivisionSteps steps) {
    int dividend = steps.getDividend();
    int difference = dividend - steps.getDivisor() * steps.getQuotient();
    if (difference == 0) {
      return "";
    }
    int lengthDividend = FormatterUtils.length(dividend);
    int lengthDifference = FormatterUtils.length(difference);
    return "\n" + FormatterUtils.repeat(' ', lengthDividend - lengthDifference + 1) + difference;
  }

}
