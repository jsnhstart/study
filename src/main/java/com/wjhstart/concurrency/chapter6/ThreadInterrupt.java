package com.wjhstart.concurrency.chapter6;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/22 20:44
 */

/**
 * 1.调用interrupt()方法，立刻改变的是中断状态，但如果不是在阻塞态，就不会抛出异常；
 * 如果在进入阻塞态后，中断状态为已中断，就会立刻抛出异常
 * <p>
 * 2.interrupt()是用来设置中断状态的。返回true说明中断状态被设置了而不是被清除了。我们调用
 * sleep、wait、join等此类可中断(throwInterruptedException)方法时，一旦方法抛出InterruptedException，
 * 当前调用方法的线程的中断状态就会被jvm清除了，就是说我们调用该线程的isInterrepted的方法时返回false。如果
 * 想保持中断状态，可再次调用interrupt方法设置中断状态。这样做的原因是，java的中断并不是真正的中断线程，而
 * 只是设置标志位（中断位）来通知用户。如果你捕获到中断异常，说明当前线程已经被中断，不需要继续保持中断位了。
 * interrupted是静态方法，返回的是当前线程的中断状态。例如：如果当前线程被中断（没有抛出中断异常，否则中断
 * 状态就会被清除），调用interrupted方法，第一次会返回true。然后当前线程的中断状态被方法内部清除了。第二次调用
 * 时就会返回false。如果刚开始一直调用isInterrupted，则会一直返回true，除非线程的中断状态被其他操作清除了。
 */
public class ThreadInterrupt {
    private static final Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
//                    do something
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println("收到打断信号...");
                        e.printStackTrace();
                    }

//                    while (true) {
//                        synchronized (MONITOR) {
//                            try {
//                                MONITOR.wait(10);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }

//                        }
//                    }
                }
            }
        };

//        Thread thread = new Thread(() -> {
//            while (true) {
//                synchronized (MONITOR) {
//                    try {
//                        MONITOR.wait(10);
//                    } catch (InterruptedException e) {
//                        System.out.println(Thread.interrupted());
//                    }
//
//                }
//            }
//        });


        t.start();
        System.out.println(t.isInterrupted());
        t.interrupt();

        Thread.sleep(1_000);
        System.out.println(t.isInterrupted());

    }

}

