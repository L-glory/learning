package com.glory.learning.provider.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Glory
 * @create 2020-05-13 22:21
 **/
public class ThreadInterruptDebug {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            LockSupport.park();
        },"interrupt-thread");
        t.start();
        Thread.sleep(100L);
        t.interrupt();
        System.out.println("中断状态：" + t.isInterrupted());
        t.join();
        System.out.println("完事");
    }

}
