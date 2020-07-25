package com.glory.learning.provider.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * volatile测试
 *
 * @author Glory
 * @create 2020-04-14 21:09
 **/
public class VolatileThreadTest {

    private static volatile int val = 0;

    private static Object lock = new Object();
    private static Object lock2 = new Object();

    private static ExecutorService executorService = Executors.newFixedThreadPool(100);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                synchronized (lock2) {
                    try {
                        lock.wait();
                        System.out.println("正常唤醒");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (;;){
                        Thread.currentThread().onSpinWait();
                    }
                }
            }
        }, "wait-thread");
        thread.setDaemon(true);
        thread.start();

        Thread notifyThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("唤醒所有线程");
                lock.notifyAll();
                System.out.println("唤醒完事");
            }
        }, "notify-thread");
        notifyThread.start();


        Thread interruptThread = new Thread(() -> {
            System.out.println("中断thread线程");
            thread.interrupt();
            System.out.println("中断完事");
        }, "interruptThread-thread");
        interruptThread.start();

        Thread.sleep(1000);
        System.out.println(String.format("thread's interrupt_status=%b, isAlive=%b\n", thread.isInterrupted(), thread.isAlive()));
    }
}
