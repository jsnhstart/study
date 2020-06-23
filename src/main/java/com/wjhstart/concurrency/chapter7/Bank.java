package com.wjhstart.concurrency.chapter7;


/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/20 17:22
 */
public class Bank {

    public static void main(String[] args) {
//        TicketWindowRunnable ticketWindow = new TicketWindowRunnable();
//        TicketWindowRunnable1 ticketWindow = new TicketWindowRunnable1();
        TicketWindowRunnable2 ticketWindow = new TicketWindowRunnable2();

        Thread thread = new Thread(ticketWindow, "0号窗口");
        Thread thread1 = new Thread(ticketWindow, "1号窗口");
        Thread thread2 = new Thread(ticketWindow, "2号窗口");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
