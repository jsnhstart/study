package com.wjhstart.concurrency.chapter2;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/20 20:50
 */
public class CalculatorStrategyImpl  implements CalculatorStrategy{

    private final static double SALARY_RATE = 0.1;
    private final static double BONUS_RATE = 0.15;

    public double calculate(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }
}
