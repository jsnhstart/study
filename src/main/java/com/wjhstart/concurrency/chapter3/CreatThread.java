package com.wjhstart.concurrency.chapter3;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/21 9:08
 */

import sun.nio.cs.ext.TIS_620;

import java.sql.SQLOutput;

/**
 * 1.创建线程对象，默认有一个线程名，以Thread-开头，从0开始计数
 * 构造函数Thread()
 * Thread-0
 * Thread-1
 *2.如果在构造Thread的时候没有传递Runnbale或者没有复写Thread的run方法，该Thread将不会执行任何东西，
 * 如果传递了Runnable接口的实例，或者覆写了Thread的run方法，则会执行该方法的逻辑单元（逻辑代码）
 *
 *
 */
public class CreatThread {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        t1.start();
        t2.start();
        System.out.println(t1.getName());
        System.out.println(t2.getName());

        Thread t3 = new Thread(){
            @Override
            public void run() {
                System.out.println("===========");
            }
        };
        t3.start();

        System.out.println(t3.getName());

        Thread t4 = new Thread("MyThread");
        t4.start();
        System.out.println(t4.getName());

        Thread t5 = new Thread(() ->{
            System.out.println("Runnable ...");
        });
        t5.start();
        System.out.println(t5.getName());

        Thread t6 = new Thread(() ->{
            System.out.println("Runnable ..." + Thread.currentThread().getName());
        },"Runnable-Thread");

        t6.start();
    }

}
