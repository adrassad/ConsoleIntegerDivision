package com.ua.foxminded.integerdivision;

public class DivisionStep {

  private final int minuend;
  private final int subtrahend;
  private final int difference;

  DivisionStep(int minuend, int subtrahend) {
    this.minuend = minuend;
    this.subtrahend = subtrahend;
    this.difference = minuend - subtrahend;
  }

  public final int getMinuend() {
    return minuend;
  }

  public final int getSubtrahend() {
    return subtrahend;
  }

  public final int getDifference() {
    return difference;
  }

  @Override
  public String toString() {
    return minuend + "\n"+
    FormatterUtils.repeat(' ', FormatterUtils.calculateLengthDifference(minuend, subtrahend))+
    subtrahend + "\n"+FormatterUtils.repeat('-', FormatterUtils.length(subtrahend))+"\n"+
    FormatterUtils.repeat(' ', FormatterUtils.calculateLengthDifference(minuend, difference)) + difference;
  }

}