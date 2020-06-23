package com.wjhstart.concurrency.chapter5;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/22 20:24
 */
public class ThreadJoin3 {

    public static void main(String[] args) throws InterruptedException {

        long startTimestamp = System.currentTimeMillis();
        Thread t1 = new Thread(new CaptureRunnable("M1",10_000));
        Thread t2 = new Thread(new CaptureRunnable("M2",30_000));
        Thread t3 = new Thread(new CaptureRunnable("M3",15_000));

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        long endTimestamp = System.currentTimeMillis();
        System.out.printf("Save data begin timestamp is %s, end timestamp is %s\n",startTimestamp,endTimestamp);
    }

}

class CaptureRunnable implements  Runnable{

    private String machineName;

    private long spendTime;

    CaptureRunnable(String machineName, long spendTime) {
        this.machineName = machineName;
        this.spendTime = spendTime;
    }


    @Override
    public void run() {
        // do the really capture data.
        try {
            Thread.sleep(spendTime);
            System.out.printf(machineName + " completed data capture at timestamp [%s] and successful.\n", System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  String getResult(){

        return machineName + "finish";
    }
}