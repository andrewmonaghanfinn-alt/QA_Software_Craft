package com.agile.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.agile.calculator.Calculator;

public class CalculatorTest {

	private Calculator calculator;

	//new tests
	@Test
	public void subtract_nonNumberInput_ReturnsMinus9999() {
		calculator = new Calculator();
		int expected = -9999;
		int actual = calculator.subtract("a,1");
		assertEquals(expected, actual);
	}

	@Test
	public void subtract_doubleNonNumberInput_ReturnsMinus9999() {
		calculator = new Calculator();
		int expected = -9999;
		int actual = calculator.subtract("a,b");
		assertEquals(expected, actual);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void subtract_inputWithoutComma_ThrowsArrayException() {
		calculator = new Calculator();
		int actual = calculator.subtract("12");
	}

	@Test(expected = NumberFormatException.class)
	public void subtract_emptyInput_ThrowsNumberFormatException() {
		calculator = new Calculator();
		int actual = calculator.subtract("");
	}

	@Test
	public void divide_doubleNonNumberInput_ReturnsMinus9999() {
		calculator = new Calculator();
		int expected = -9999;
		int actual = calculator.divide("a,b");
		assertEquals(expected, actual);
	}

	@Test(expected = StringIndexOutOfBoundsException.class)
	public void divide_inputWithoutComma_ThrowsStringException() {
		calculator = new Calculator();
		int actual = calculator.divide("12");
	}

	@Test(expected = StringIndexOutOfBoundsException.class)
	public void divide_emptyInput_ThrowsStringException() {
		calculator = new Calculator();
		int actual = calculator.divide("");
	}

	@Test
	public void divide_noCommaWithSpace_ReturnsMinus9999() {
		calculator = new Calculator();
		int expected = 30;
		int actual = calculator.divide("60 2");
		assertEquals(expected, actual);
	}

	@Test
	public void multiply_nonNumberInput_ReturnsMinus9999() {
		calculator = new Calculator();
		int expected = -9999;
		int actual = calculator.multiply("100, x");
		assertEquals(expected, actual);
	}
	
	

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
	
	
	

}
