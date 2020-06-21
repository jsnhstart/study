package com.wjhstart.concurrency.chapter3;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/21 9:35
 */

/**
 * 3.构造线程对象时，未传入ThreadGroup，Thread会默认获取父线程的ThreadGroup作为该线程的ThreadGroup，
 * 此时子线程和父线程将会在同一个ThreadGroup中
 */
public class CreatThread2 {

    public static void main(String[] args) {
//        Thread t1 = new Thread();
//        t1.start();
//        System.out.println(t1.getThreadGroup().getName());
//
//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getThreadGroup().getName());

        Thread t2 = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t2.start();

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        int activeCount = threadGroup.activeCount();
        System.out.println(activeCount);

        Thread[] threads = new Thread[activeCount];
        threadGroup.enumerate(threads);
        for (Thread thread : threads){
            System.out.println(thread);
        }
    }
}
