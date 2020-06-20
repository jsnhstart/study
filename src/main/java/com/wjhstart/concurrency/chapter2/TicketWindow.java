package com.wjhstart.concurrency.chapter2;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/20 17:22
 */
public class TicketWindow extends Thread {

    private final String name;

    private static final int MAX = 50;

    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX){
            System.out.println("柜台："+name+"号码"+(index++));
        }
    }
}
