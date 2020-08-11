package com.glory.learning.provider.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch调试
 *
 * @author Glory
 * @create 2020-05-04 17:11
 **/
public class CountDownLatchDebug {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        new Thread(() -> {
            System.out.println("线程三等待");
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程三执行完事");
        }, "worker-thread-3").start();
        Thread.sleep(100);
        new Thread(() -> {
            System.out.println("线程一执行任务");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            System.out.println("线程一执行完事");
        }, "worker-thread-1").start();
        new Thread(() -> {
            System.out.println("线程二执行任务");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            System.out.println("线程二执行完事");
        }, "worker-thread-2").start();
        // 等待两个worker线程完事
        latch.await();
        System.out.println("完事啦");
        Thread.sleep(200);
    }
}
