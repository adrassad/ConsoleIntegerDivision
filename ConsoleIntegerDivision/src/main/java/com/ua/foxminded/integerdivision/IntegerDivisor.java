package com.ua.foxminded.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class IntegerDivisor {

  public DivisionSteps generateDivisionSteps(int dividend, int divisor) {
    if (divisor == 0) {
      throw new IllegalArgumentException("divisor cannot be zero");
    } else if (dividend < divisor) {
      throw new IllegalArgumentException("dividend cannot be less divisor");
    }
    int quotient = dividend / divisor;
    int mutableDividend = dividend;
    List<DivisionStep> listSteps = new ArrayList<DivisionStep>();
    for (int partQuotient : FormatterUtils.decomposeNumbers(quotient)) {
      int subtrahend = partQuotient * divisor;
      int minuend = generateMinuend(mutableDividend, subtrahend);
      mutableDividend = changeMutableDividend(mutableDividend, minuend, minuend - subtrahend);
      listSteps.add(new DivisionStep(minuend, subtrahend));
    }
    DivisionSteps steps = new DivisionSteps(dividend, divisor, listSteps);
    return steps;
  }

  private int changeMutableDividend(int mutableDividend, int minuend, int difference) {
    int[] numbersMutableDividend = FormatterUtils.decomposeNumbers(mutableDividend);
    int[] numbersdifference = FormatterUtils.decomposeNumbers(difference);
    int maxIndexMinuend = FormatterUtils.length(minuend) - 1;
    int maxIndexDifference = FormatterUtils.length(difference) - 1;
    for (int i = maxIndexMinuend; i >= 0; i--) {
      if (maxIndexDifference < 0) {
        numbersMutableDividend[i] = 0;
      } else {
        numbersMutableDividend[i] = numbersdifference[maxIndexDifference--];
      }
    }
    return FormatterUtils.collectNumber(numbersMutableDividend, numbersMutableDividend.length);
  }

  private int generateMinuend(int mutableDividend, int subtrahend) {
    if (subtrahend == 0) {
      return 0;
    }
    int minuend = mutableDividend;
    int lengthMinuend = FormatterUtils.length(mutableDividend);
    int[] dividend = FormatterUtils.decomposeNumbers(mutableDividend);
    for (int i = 1; lengthMinuend >= i; i++) {
      minuend = FormatterUtils.collectNumber(dividend, i);
      if (minuend >= subtrahend) {
        return minuend;
      }
    }
    return minuend;
  }

}
