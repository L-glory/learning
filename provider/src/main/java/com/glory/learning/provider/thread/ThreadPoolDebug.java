package com.glory.learning.provider.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 线程池debug
 *
 * @author Glory
 * @create 2020-05-10 20:34
 **/
public class ThreadPoolDebug {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(-1 << (Integer.SIZE - 3));
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 100; i++) {
            threadPool.submit(() -> {
                System.out.println(Thread.currentThread());
            });
            Thread.sleep(500L);
        }
        Thread.sleep(2000L);
    }

}
