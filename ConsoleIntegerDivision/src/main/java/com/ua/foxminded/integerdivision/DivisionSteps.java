package com.ua.foxminded.integerdivision;

import java.util.List;

public class DivisionSteps {

  private final int dividend;
  private final int divisor;
  private final int quotient;
  private final List<DivisionStep> listSteps;

  DivisionSteps(int dividend, int divisor, List<DivisionStep> listSteps) {
    this.dividend = dividend;
    this.divisor = divisor;
    this.quotient = dividend / divisor;
    this.listSteps = listSteps;
  }

  public final int getQuotient() {
    return quotient;
  }

  public final int getDividend() {
    return dividend;
  }

  public final int getDivisor() {
    return divisor;
  }

  public final List<DivisionStep> getListSteps() {
    return listSteps;
  }

}
