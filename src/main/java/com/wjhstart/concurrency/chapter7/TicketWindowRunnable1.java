package com.wjhstart.concurrency.chapter7;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/23 20:49
 */
public class TicketWindowRunnable1 implements Runnable{

    private static final int MAX = 500;

    private static int index = 1;

    //this锁 单线程执行
    @Override
    public synchronized void run() {
        while (true) {
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
