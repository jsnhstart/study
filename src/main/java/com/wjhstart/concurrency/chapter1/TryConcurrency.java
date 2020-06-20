package com.wjhstart.concurrency.chapter1;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/20 15:51
 */
public class TryConcurrency {

    public static void main(String[] args) {

        new Thread("Read-Thread"){
            @Override
            public void run() {
                readFromDataBase();
            }
        }.start();

        new Thread("Write-Thread"){
            @Override
            public void run() {
                writeDataToFile();
            }
        }.start();
    }

    private static void readFromDataBase(){
        //read data from database and handle it.

        try {
            println("Begin read data from db.");
            Thread.sleep(1000 * 10L);
            println("Read data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("The data handle finish and successfully.");
    }

    private static void writeDataToFile(){
        try {
            println("Begin write data to file.");
            Thread.sleep(1000 * 10L);
            println("Write data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("The data handle finish and successfully.");
    }

    private static void println(String msg){
        System.out.println(msg);
    }
}
