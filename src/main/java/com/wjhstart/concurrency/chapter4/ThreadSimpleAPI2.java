package com.wjhstart.concurrency.chapter4;

import java.util.Optional;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/21 16:30
 */
public class ThreadSimpleAPI2 {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Optional.of(Thread.currentThread().getName() + "-index" + i).ifPresent(System.out::println);
            }
        });
        t1.setPriority(Thread.MAX_PRIORITY);


        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Optional.of(Thread.currentThread().getName() + "-index" + i).ifPresent(System.out::println);
            }
        });
        t2.setPriority(Thread.MIN_PRIORITY);

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Optional.of(Thread.currentThread().getName() + "-index" + i).ifPresent(System.out::println);
            }
        });
        t3.setPriority(Thread.NORM_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

    }
}
