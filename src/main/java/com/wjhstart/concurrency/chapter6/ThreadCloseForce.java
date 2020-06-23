package com.wjhstart.concurrency.chapter6;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/23 9:49
 */
public class ThreadCloseForce {

    public static void main(String[] args) throws InterruptedException {
        ThreadService service = new ThreadService();
        long startTime = System.currentTimeMillis();
        service.execute(() -> {
            //connection or read big file.
            while (true){

            }
//            try {
//                Thread.sleep(5_000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        });
        service.shutdown(15_000);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
