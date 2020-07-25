package com.glory.learning.provider.unsafe;

import java.util.concurrent.locks.LockSupport;

/**
 * unsafe使用用例
 *
 * @author Glory
 * @create 2020-04-19 14:46
 **/
public class UnsafeUseCase {

    private static final UnsafeUseCase BLOCKER = new UnsafeUseCase();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            LockSupport.park(BLOCKER);
            System.out.println(String.format("isInterrupt=%b", Thread.currentThread().isInterrupted()));
        }, "park-thread");
        thread.start();
        Thread.sleep(200);
        thread.interrupt();
        Thread.sleep(200);
        System.out.println("park执行之后，线程中断，但是不抛出异常");
    }

}
