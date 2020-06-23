package com.wjhstart.concurrency.chapter7;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/23 21:38
 */

/**
 * 形式1：synchronized 加载 static 方法上
 * 形式2：synchronized (*.class) 代码块
 */
public class SynchronizedStaticTest {
    public static void main(String[] args) {
        SynchronizedStatic synchronizedStatic = new SynchronizedStatic();
        new Thread(() -> {
            synchronizedStatic.obj1();
        }).start();
        new Thread(() -> {
            SynchronizedStatic.obj3();
        }).start();
    }
}
