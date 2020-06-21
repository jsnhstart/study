package com.wjhstart.concurrency.chapter3;

/**
 * @author wjhstart
 * @version 1.0
 * @date 2020/6/21 15:03
 */

/**
 * 构造Thread的时候传入stacksize代表着该线程占用的stack的大小，如果没有指定stacksize的大小，默认是0，
 * 0代表忽略该参数，该参数会被JNI函数去使用，注意：该参数有一些平台有效，有些平台无效。
 *  一般使用 -Xss 10M 指定
 */
public class CreatThread3 {

    private static int counter = 1;
    public static void main(String[] args) {
        new Thread(null,() ->{
            try {
                add(0);
            }catch (Error e){
                System.out.println(counter);
            }
        },"Test", 1 << 24).start();

    }

    private static void add(int i) {
        counter++;
        add(i + 1);
    }
}
