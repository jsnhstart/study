package com.wjhstart.concurrency.chapter8;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/29 20:13
 */

/**
 * 1.当前线程拥有其他线程需要的资源
 * 2.当前线程等待其他线程已拥有的资源
 * 3.都不放弃自己拥有的资源
 */
public class DeadLock {
    private OtherService otherService;

    DeadLock(OtherService otherService){
        this.otherService = otherService;
    }

    private final Object lock = new Object();

    public void m1 (){
        synchronized (lock){
            otherService.s1();
        }
    }

    public void m2(){
        System.out.println("m2");
    }
}
