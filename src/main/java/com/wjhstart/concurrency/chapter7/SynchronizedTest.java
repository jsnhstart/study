package com.wjhstart.concurrency.chapter7;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/23 20:24
 */

/**
 * 1..一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞
 */
public class SynchronizedTest {

    private final  static Object LOCK = new Object();
    public static void main(String[] args) {
        Runnable runnable = () -> {
            synchronized (LOCK){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();
    }
}
