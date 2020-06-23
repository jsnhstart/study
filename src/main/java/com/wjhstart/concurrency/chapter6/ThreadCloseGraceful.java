package com.wjhstart.concurrency.chapter6;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/23 20:24
 */
public class ThreadCloseGraceful {

    private static  class Worker extends Thread{

        private volatile boolean start = true;

        @Override
        public void run() {
            while (start){
                //TODO
            }
        }

        public void shutdown(){
            this.start = false;
        }

    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            //主线程等待worker线程后结束worker
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.shutdown();
    }
}
