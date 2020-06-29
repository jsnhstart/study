package com.wjhstart.concurrency.chapter8;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/29 20:14
 */
public class OtherService {

    private DeadLock deadLock;

    private final Object lock = new Object();

    public void setDeadLock(DeadLock deadLock){
        this.deadLock = deadLock;
    }

    public void s1() {
        synchronized (lock){
            System.out.println("s1");
        }
    }

    public void s2(){
        synchronized (lock){
            deadLock.m2();
        }
    }
}
