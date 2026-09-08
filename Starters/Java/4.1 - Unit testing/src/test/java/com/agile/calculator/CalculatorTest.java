package com.agile.calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calculator;

	@Before
	public void setUp() {
		calculator = new Calculator();
	}

	@Test
	public void subtraction_largerBySmaller_ReturnsPositive(){
		//arrange
		int expected = 45;
		//act
		int result = calculator.subtract("100,55");
		//assert
		assertEquals(expected, result);
	}

	@Test
	public void subtraction_smallerByLarger_ReturnsNegative(){
		//arrange
		int expected = -8;
		//act
		int result = calculator.subtract("56,64");
		//assert
		assertEquals(expected, result);
	}

	@Test
	public void subtraction_NonNumberInput_ReturnsMinus9999(){
		//arrange
		int expected = -9999;
		//act
		int result = calculator.subtract("a,b");
		//assert
		assertEquals(expected, result);
	}

	@Test
	public void multiply_largerBySmaller_ReturnsPositive(){
		//arrange
		int expected = 51;
		//act
		int result = calculator.multiply("17,3");
		//assert
		assertEquals(expected, result);
	}

	@Test
	public void multiply_positiveByNegative_ReturnsNegative(){
		//arrange
		int expected = -12;
		//act
		int result = calculator.multiply("3,-4");
		//assert
		assertEquals(expected, result);
	}

	@Test
	public void multiply_negativeByNegative_ReturnsPositive(){
		//arrange
		int expected = 90;
		//act
		int result = calculator.multiply("-10,-9");
		//assert
		assertEquals(expected, result);
	}

	@Test
	public void multiply_nonNumberInput_ReturnsMinus9999(){
		//arrange
		int expected = -9999;
		//act
		int result = calculator.multiply("c,d");
		//assert
		assertEquals(expected, result);
	}

	@Test
	public void divide_largerBySmaller_ReturnsGreaterThan1(){
		//arrange
		int expected = 7;
		//act
		int result = calculator.divide("42,6");
		//assert
		assertEquals(expected, result);
	}

	@Test
	public void divide_smallerByLarger_ReturnsZero(){
		//arrange
		int expected = 0;
		//act
		int result = calculator.divide("5,9");
		//assert
		assertEquals(expected, result);
	}

	@Test(expected = ArithmeticException.class)
	public void divide_positiveByZero_ThrowsArithmeticException(){
		//act
		calculator.divide("1,0");
	}

}
