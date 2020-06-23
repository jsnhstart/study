package com.wjhstart.concurrency.chapter7;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/23 20:59
 */

/**
 * this关键字
 * 1.可以区分局部变量和成员变量同名的问题
 * 2.代表的是当前对象的引用。谁来调我，我代表谁
 * 3.调用本类的其他构造方法，只能放在构造参数第一行。
 */
public class SynchronizedThis {

    public static void main(String[] args) {
        ThisLock thisLock = new ThisLock();
        Thread t1 = new Thread(() ->{
            thisLock.m1();
        });

        Thread t2 = new Thread(() ->{
            thisLock.m3();
        });

        t1.start();
        t2.start();
    }
}

class ThisLock{

    private final Object LOCK = new Object();

    public synchronized void m1(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void m2(){
        synchronized(LOCK){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  void m3(){
        synchronized(this){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}