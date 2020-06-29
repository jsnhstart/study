package com.wjhstart.concurrency.chapter9;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/29 21:03
 */

/**
 * wait方法时可中断方法，这也就意味着，当前线程一旦调用了wait方法进入阻塞状态，其他线程时可以使用interrupt方法将其打断的；可以中断方法被打断后会收到中断异常InterruptedException，同时interrupt状态也会被擦除。
 * 线程执行了某个对象的wait方法以后，会加入与之对应的wait set中，每一个对象的monitor都有一个与之关联的wait set
 * 当线程进入wait set之后，notify方法可以将其唤醒，也就是从wait set弹出，同时中断wait中的线程也会被其唤醒。
 * 必须在同步方法中使用wait和notify方法，因为执行wait和notify的前提条件是必须持有同步方法的monitor的所有权，运行下面任何一个方法都会抛出非法的monitor状态异常IllegalMonitorStateException
 * 同步代码的monitor必须与执行wait notify方法的对象一致，简单地说就是用哪个对象的monitor进行同步，就只能用哪个对象进行wait和notify操作。
 * 
 * wait和sleep区别
 * wait和sleep方法都可以使线程进入阻塞状态
 * wait和sleep方法均是可中断方法，被中断后都会收到中断异常。
 * wait和Object的方法，而sleep和Thread特有的方法。
 * wait方法的执行必须在同步方法中进行，而sleep则不需要
 * 线程在同步方法中执行sleep方法时，并不会释放monitor的锁，而wait方法则会释放monitor的锁
 * sleep方法短暂休眠之后会主动退出阻塞，而wait方法（没有指定wait时间）则需要被其他线程中断后才能退出阻塞。
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 1;
        Producer p = new Producer(queue, maxSize);
        Consumer c = new Consumer(queue, maxSize);
        Thread pT = new Thread(p);
        Thread pC = new Thread(c);
        pT.start();
        pC.start();
    }
}
