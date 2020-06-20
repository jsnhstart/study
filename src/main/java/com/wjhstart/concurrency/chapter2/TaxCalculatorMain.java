package com.wjhstart.concurrency.chapter2;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/20 20:34
 */
public class TaxCalculatorMain {
    public static void main(String[] args) {
//        TaxCalculator taxCalculator = new TaxCalculator(10000,2000){
//            @Override
//            protected double calcTax() {
//                return getSalary() * 0.1 + getBonus() * 0.15;
//            }
//        };
//        double calcTax = taxCalculator.calcuate();
//        System.out.println(calcTax);


            //策略模式
//        TaxCalculator taxCalculator = new TaxCalculator(10000,2000);
//        CalculatorStrategyImpl calculatorStrategy = new CalculatorStrategyImpl();
//        taxCalculator.setCalculatorStrategy(calculatorStrategy);
//        double calcuate = taxCalculator.calcuate();
//        System.out.println(calcuate);

        //java8
        TaxCalculator taxCalculator = new TaxCalculator(10000,2000);
        taxCalculator.setCalculatorStrategy((s,b) -> s * 0.1 + b * 0.15);
        double calcuate = taxCalculator.calcuate();
        System.out.println(calcuate);


    }
}
