package com.wjhstart.concurrency.chapter2;


/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/20 17:47
 */
public class BankVersion2 {
    public static void main(String[] args) {
        final TicketWindowRunnable ticketWindowRunnable = new TicketWindowRunnable();
        Thread thread1 = new Thread(ticketWindowRunnable,"一号柜台");
        Thread thread2 = new Thread(ticketWindowRunnable,"二号柜台");
        Thread thread3 = new Thread(ticketWindowRunnable,"三号柜台");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
