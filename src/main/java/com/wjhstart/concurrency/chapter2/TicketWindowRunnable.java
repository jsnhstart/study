package com.wjhstart.concurrency.chapter2;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/20 17:40
 */
public class TicketWindowRunnable implements Runnable {

    private static final int MAX = 50;
    private int index = 1;


    public void run() {
        while (index <= MAX){
            System.out.println(Thread.currentThread().getName()+   "号码"+(index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
