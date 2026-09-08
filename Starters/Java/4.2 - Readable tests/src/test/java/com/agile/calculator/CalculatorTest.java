package com.agile.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.agile.calculator.Calculator;

public class CalculatorTest {

	private Calculator calculator;

	@Before
	public void setUp() {
		calculator = new Calculator();
	}


	@Test
	public void subtract_smallerFromLarger_ReturnsPositive() {
		//arrange
		int expected = 2;
		//act
		int actual = calculator.subtract("5,3");
		//assert
		assertEquals(expected, actual);
	}

	@Test
	public void subtract_positiveFromNegative_ReturnsNegative() {
		//arrange
		int expected = -8;
		//act
		int actual = calculator.subtract("-5,3");
		//assert
		assertEquals(expected, actual);
	}

	//removed redundant test

	@Test
	public void divide_largerBySmaller_ReturnsGreaterThan1() {
		//arrange
		int expected = 5;
		//act
		int actual = calculator.divide("10,2");
		//assert
		assertEquals(expected, actual);
	}
	@Test
	public void divide_positiveByNegative_ReturnsNegative() {
		//arrange
		int expected = -5;
		//act
		int actual = calculator.divide("10,-2");
		//assert
		assertEquals(expected, actual);
	}
	@Test
	public void multiply_twoPositive_ReturnsPositive() {
		int expected = 50;
		int actual = calculator.multiply("25,2");
		assertEquals(expected, actual);
	}
	
	//removed redundant test
	
	@Test(expected = java.lang.ArithmeticException.class)
	public void divide_positiveByZero_throwsArithmeticException() {
		calculator.divide("10,0");
	}

}
