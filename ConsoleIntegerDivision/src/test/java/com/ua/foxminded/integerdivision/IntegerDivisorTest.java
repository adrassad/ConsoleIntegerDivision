package com.ua.foxminded.integerdivision;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class IntegerDivisorTest {

  @Test
  void fromTask() {
    IntegerDivisor integerDivisor = new IntegerDivisor();
    DivisionSteps steps = integerDivisor.generateDivisionSteps(78945, 4);
    DivisionPrinter printer = new DivisionPrinter();
    assertEquals(
        "_78945|4\n" + " 4    |-----\n" + " -    |19736\n" + "_38\n" + " 36\n" + " --\n" + " _29\n" + "  28\n"
            + "  --\n" + "  _14\n" + "   12\n" + "   --\n" + "   _25\n" + "    24\n" + "    --\n" + "     1",
        printer.formatDivisionSteps(steps));
  }

  @Test
  void divisorIsZero() {
    IntegerDivisor integerDivisor = new IntegerDivisor();
    Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
      DivisionSteps steps = integerDivisor.generateDivisionSteps(0, 0);
    });
    assertEquals("divisor cannot be zero", thrown.getMessage());
  }

  @Test
  void longDivisionWithZeroDividend() {
    IntegerDivisor integerDivisor = new IntegerDivisor();
    Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
      DivisionSteps steps = integerDivisor.generateDivisionSteps(0, 1);
    });
    assertEquals("dividend cannot be less divisor", thrown.getMessage());
  }

  @Test
  void twoDigitDivisor() {
    IntegerDivisor integerDivisor = new IntegerDivisor();
    DivisionSteps steps = integerDivisor.generateDivisionSteps(11234, 22);
    DivisionPrinter printer = new DivisionPrinter();
    assertEquals("_11234|22\n" + " 110  |---\n" + " ---  |510\n" + "  _23\n" + "   22\n" + "   --\n" + "    14",
        printer.formatDivisionSteps(steps));
  }

  @Test
  void threeDigitDivisor() {
    IntegerDivisor integerDivisor = new IntegerDivisor();
    DivisionSteps steps = integerDivisor.generateDivisionSteps(11234, 222);
    DivisionPrinter printer = new DivisionPrinter();
    assertEquals("_11234|222\n" + " 1110 |---\n" + " ---- |50\n" + "   134", printer.formatDivisionSteps(steps));
  }

  @Test
  void testStepDivision() {
    IntegerDivisor integerDivisor = new IntegerDivisor();
    DivisionSteps steps = integerDivisor.generateDivisionSteps(78945, 4);
    List<DivisionStep> stepsDivision = steps.getListSteps();
    assertEquals("7\n" + "4\n" + "-\n" + "3", stepsDivision.get(0).toString());
  }

  @Test
  void testSizeStepsDivision() {
    IntegerDivisor integerDivisor = new IntegerDivisor();
    DivisionSteps steps = integerDivisor.generateDivisionSteps(78945, 4);
    List<DivisionStep> stepsDivision = steps.getListSteps();
    assertEquals(5, stepsDivision.size()); // we expecting size to be 2
  }
  
}
