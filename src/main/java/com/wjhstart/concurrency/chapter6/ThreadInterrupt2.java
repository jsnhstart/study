package com.wjhstart.concurrency.chapter6;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/23 21:04
 */
public class ThreadInterrupt2 {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                //do something
            }
        });
        thread.start();

        Thread main = Thread.currentThread();

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                thread.interrupt();
////                System.out.println("thread interrupt done.");
                main.interrupt();
                System.out.println("main interrupt done.");
            }
        };
        thread1.start();

        try {
            //mian线程阻塞，打断thread并不会抛出异常。
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
