package com.wjhstart.concurrency.chapter6;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/23 9:37
 */
public class ThreadCloseGraceful2 {

    private static  class Worker extends Thread{

        @Override
        public void run() {
            while (true){
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    break; //return
//                }
                if (Thread.interrupted()){
                    break;  //return后无法执行判断后的逻辑
                }
            }
        }
    }
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        try {
            //主线程等待worker线程后结束worker
            Thread.sleep(4_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.interrupt();
    }
}
