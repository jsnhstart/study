package com.wjhstart.concurrency.chapter9;

import java.util.Queue;
import java.util.Random;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/29 21:01
 */
public class Producer implements Runnable{

    private Queue<Integer> queue;
    private int maxSize;

    public Producer(Queue<Integer> queue, int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while (queue.size() == maxSize){
                    try{
                        System.out.println("Queue is Full");
                        queue.wait();
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                Random random = new Random();
                int i = random.nextInt();
                System.out.println("Produce " + i);
                queue.add(i);
                queue.notifyAll();
            }
        }
    }
}