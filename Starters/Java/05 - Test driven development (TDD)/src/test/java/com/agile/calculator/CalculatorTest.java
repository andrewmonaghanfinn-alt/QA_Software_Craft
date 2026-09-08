package com.agile.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.agile.calculator.Calculator;

public class CalculatorTest {

	private Calculator calculator;

	@Test
	public void subtractTest() {
		calculator = new Calculator();
		int expected = 2;
		int actual = calculator.subtract("5,3");
		assertEquals(expected, actual);
	}

	@Test
	public void subtract2Test() {
		calculator = new Calculator();
		int expected = -8;
		int actual = calculator.subtract("-5,3");
		assertEquals(expected, actual);
	}

	@Test
	public void subtract3Test() {
		calculator = new Calculator();
		int expected = 2;
		int actual = calculator.subtract("4,2");
		assertEquals(expected, actual);
	}

	@Test
	public void divide() {
		calculator = new Calculator();
		int expected = 5;
		int actual = calculator.divide("10,2");
		assertEquals(expected, actual);
	}
	@Test
	public void divide2() {
		calculator = new Calculator();
		int expected = -5;
		int actual = calculator.divide("10,-2");
		assertEquals(expected, actual);
	}
	@Test
	public void multiply() {
		calculator = new Calculator();
		int expected = 50;
		int actual = calculator.multiply("25,2");
		assertEquals(expected, actual);
	}
	@Test
	public void multiply2() {
		calculator = new Calculator();
		int expected = 600;
		int actual = calculator.multiply("150,4");
		assertEquals(expected, actual);
	}
	
	@Test(expected = java.lang.ArithmeticException.class)
	public void dividewithsomeexception() {
		calculator = new Calculator();
		calculator.divide("10,0");
	}

	@Test
	public void add_emptyString_returns0() {
		calculator = new Calculator();
		int expected = 0;

		int actual = calculator.add("");

		assertEquals(expected, actual);
	}

	@Test
	public void add_singleNumber_returnsNumber() {
		calculator = new Calculator();
		int expected = 5;

		int actual = calculator.add("5");

		assertEquals(expected, actual);
	}

	@Test
	public void add_twoNumbers_returnSum() {
		calculator = new Calculator();
		int expected = 80;

		int actual = calculator.add("32,48");

		assertEquals(expected, actual);
	}

	@Test
	public void add_twoNumbersWithNewline_returnSum() {
		calculator = new Calculator();
		int expected = 2;

		int actual = calculator.add("1 1");

		assertEquals(expected, actual);
	}

	@Test
	public void add_threeNumbers_returnSum() {
		calculator = new Calculator();
		int expected = 15;

		int actual = calculator.add("3,5,7");

		assertEquals(expected, actual);
	}

	@Test(expected = ArithmeticException.class)
	public void add_negativeNumber_throwsArithmeticException() {
		calculator = new Calculator();

		calculator.add("1,-5,8");
	}


}
