package com.wjhstart.concurrency.chapter7;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/23 20:53
 */
public class TicketWindowRunnable2 implements Runnable{
    private static final int MAX = 500;

    private static int index = 1;

    @Override
    public void run() {
        while (true) {
            if(ticket()){
                break;
            }
        }
    }

    //同步代码块
    private synchronized boolean ticket() {
        if (index > MAX) {
            return true;
        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("柜台：" + Thread.currentThread().getName() + "号码 " + (index++));
        return false;
    }
}
