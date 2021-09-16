package com.ua.foxminded.integerdivision;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Input a dividend : ");
    int dividend = in.nextInt();
    System.out.print("Input a divisor : ");
    int divisor = in.nextInt();
    IntegerDivisor integerDivisor = new IntegerDivisor();
    DivisionSteps steps = integerDivisor.generateDivisionSteps(dividend, divisor);
    DivisionPrinter printer = new DivisionPrinter();
    printer.print(steps);
  }

}
