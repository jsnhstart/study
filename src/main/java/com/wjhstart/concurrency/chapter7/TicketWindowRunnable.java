package com.wjhstart.concurrency.chapter7;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/20 17:22
 */
public class TicketWindowRunnable extends Thread {

    private static final int MAX = 500;

    private static int index = 1;

    private final Object MONITOR = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (MONITOR) {
                if (index > MAX) {
                    break;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("柜台：" + Thread.currentThread().getName() + "号码 " + (index++));
            }
        }
    }
}
