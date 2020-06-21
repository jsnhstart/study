package com.wjhstart.concurrency.chapter4;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/21 15:22
 */
public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        //new 状态
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " running");
                    Thread.sleep(100_000);
                    System.out.println(Thread.currentThread().getName() + " done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //设置守护线程
        thread.setDaemon(true);
        //runnable -> running -> blocked -> dead
        thread.start();

        Thread.sleep(5_000);
        System.out.println(Thread.currentThread().getName());
    }
}
