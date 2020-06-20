package com.wjhstart.concurrency.chapter2;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/20 20:08
 */
public class TaxCalculator {

     private final double salary;

     private final double bonus;

     private CalculatorStrategy calculatorStrategy;

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setCalculatorStrategy(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = calculatorStrategy;
    }

    public TaxCalculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    protected double calcTax(){
        return calculatorStrategy.calculate(salary, bonus);
    }

    public double calcuate(){
        return calcTax();
    }
}
