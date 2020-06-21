package com.wjhstart.concurrency.chapter4;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/21 15:46
 */
public class DaemonThread2 {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Thread innerThread = new Thread(() -> {
                    try {
                        while (true){
                            System.out.println("do something for health check.");
                            Thread.sleep(10_000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
//            innerThread.setDaemon(true);
            innerThread.start();
        });

        try {
            Thread.sleep(5_000);
            System.out.println("T thread finish done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.start();
    }
}
