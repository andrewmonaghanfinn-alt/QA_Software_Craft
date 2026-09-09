package com.qa.core;

public class Calculator {
    private int result;

    public void addTwoNumber(int x, int y) {
        result = x + y;
    }

    public void subtractTwoNumber(int x, int y) {
        result = y - x;
    }

    public void multiplyTwoNumber(int x, int y) {
        result = x * y;
    }
 
    public int getresult() {
        return result;
    }
}

