package com.wjhstart.concurrency.chapter4;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/21 16:20
 */
public class ThreadSimpleAPI {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() ->{
            Optional.of("Hello").ifPresent(System.out::println);
        },"t1");
        Thread.sleep(1_000);

        t.start();
        Optional.of(t.getName()).ifPresent(System.out::println);
        Optional.of(t.getId()).ifPresent(System.out::println);
        Optional.of(t.getPriority()).ifPresent(System.out::println);
    }
}
