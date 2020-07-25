package com.glory.learning.provider.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁调试
 *
 * @author Glory
 * @create 2020-04-22 23:05
 **/
public class ReenTrantLockDebug {

    private static final ReentrantLock LOCK = new ReentrantLock();

    private static final Object SYNC_LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread holder = new Thread(() -> {
            LOCK.lock();
            try {
                System.out.println("线程阻塞，拿住锁不释放...");
                synchronized (SYNC_LOCK) {
                    SYNC_LOCK.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }

        }, "holder-thread");
        holder.start();

        // 保证holder已经拿住锁
        Thread.sleep(200);

        Thread debug = new Thread(() -> {
            LOCK.lock();
            try {
                // 执行不到这里
            } finally {
                LOCK.unlock();
            }
        }, "debug-thread");
        debug.start();

        holder.join();
        debug.join();
    }

}
