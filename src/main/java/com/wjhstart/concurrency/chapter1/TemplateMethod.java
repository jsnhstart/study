package com.wjhstart.concurrency.chapter1;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/20 17:02
 *
 * 1.Java应用程序的main函数是一个线程，是被JVM启动的时候调用，线程名字：main
 * 2.实现一个线程，必须创建Thread实例，override run方法，并且调用start方法
 * 3.JVM启动后，实际上有多个线程，但是至少有一个非守护线程
 * 4.当你调用一个线程start方法时，此时至少有两个线程，一个是调用你的线程（main），还有一个执行run方法的线程
 * 5.线程的生命周期分为：new，runnable，running，block，terminated
 *
 */
public class TemplateMethod {

    public final void print(String message){
        System.out.println("=========");
        wrapPrint(message);
        System.out.println("=========");
    }

    protected void wrapPrint(String message) {
    }

    public static void main(String[] args) {
        TemplateMethod templateMethod = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("* " + message + " *");
            }
        };

        templateMethod.print("Hello Thread");

        TemplateMethod templateMethod1 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+ " + message + " +");
            }
        };

        templateMethod1.print("Hello Thread");

    }
}


