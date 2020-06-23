package com.wjhstart.concurrency.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/22 20:15
 */
public class ThreadJoin2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            try {
                System.out.println("t1 is running");
                Thread.sleep(10_000);
                System.out.println("t1 is done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t1.join(100,10);

        Optional.of("All of task finish done.").ifPresent(System.out::println);
        IntStream.range(1,1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));

        //等待自己，无限循环
//        Thread.currentThread().join();
    }
}
