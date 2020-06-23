package com.wjhstart.concurrency.chapter6;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/23 9:59
 */
public class ThreadService {

    private Thread executeThread;

    private boolean finished = false;

    public void execute(Runnable task ){
        executeThread = new Thread(){
            @Override
            public void run() {
                Thread runner = new Thread(task);
                runner.setDaemon(true);
                runner.start();
                try {
                    runner.join();
                    finished = true;
                } catch (InterruptedException e) {

                }
            }
        };
        executeThread.start();
    }

    public void  shutdown(long mills){
        long currentTime = System.currentTimeMillis();
        while (!finished){
            if ((System.currentTimeMillis() - currentTime) >= mills){
                System.out.println("task timeout and shutdown");
                executeThread.interrupt();
                break;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("execute interrupt !");
                break;
            }
        }

        finished = false;
    }
}
