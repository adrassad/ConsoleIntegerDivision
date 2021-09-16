package com.ua.foxminded.integerdivision;

public class FormatterUtils {

  public static int calculateLengthDifference(int master, int slave) {
    if (slave == 0) {
      return length(master);
    }
    return length(master) - length(slave);
  }

  public static String repeat(char symbol, int count) {
    char[] symbols = new char[count];
    for (int i = 0; i < count; i++) {
      symbols[i] = symbol;
    }
    return new String(symbols);
  }

  public static int length(int n) {
    if (n < 10) {
      return 1;
    }
    int length = 2;
    while (n / 10 >= 10) {
      length = length + 1;
      n = n / 10;
    }
    return length;
  }

  public static int[] decomposeNumbers(int input) {
    final int base = 10; // could be anything
    int lengthInput = length(input);
    final int[] result = new int[lengthInput];
    for (int i = lengthInput; i != 0; i--) {
      result[i - 1] = input % (base);
      input = input / base;
    }
    return result;
  }

  public static int collectNumber(int[] numbers, int count) {
    int number = 0;
    for (int i = 0; count > i; i++) {
      number = 10 * number + numbers[i];
    }
    return number;
  }

}