package com.wjhstart.concurrency.chapter9;

import java.util.Queue;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/29 21:02
 */
public class Consumer implements Runnable{

    private Queue<Integer> queue;
    private int maxSize;

    public Consumer(Queue<Integer> queue, int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while (queue.isEmpty()){
                    System.out.println("Queue is Empty");
                    try{
                        queue.wait();
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                int v = queue.remove();
                System.out.println("Consume " + v);
                queue.notifyAll();
            }
        }
    }
}