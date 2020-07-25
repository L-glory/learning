package com.glory.learning.provider.thread;

/**
 * @author Glory
 * @create 2020-04-26 21:45
 **/
public class VolatileThreadTest2 {

    private volatile static int count  = 0;

    private static void decr() {
        count--;
    }

    private static void incr() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(VolatileThreadTest2::incr, "incr-" + i).start();
        }
        while (Thread.activeCount() > 2) {
            System.out.println("activeCount=" + Thread.activeCount());
            Thread.yield();
        }
        System.out.println(count);
    }
}
