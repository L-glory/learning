package com.glory.learning.provider.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁debug
 *
 * @author Glory
 * @create 2020-04-25 21:47
 **/
public class ReentrantReadWriteLockDebug {

    private static final ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock(true);


    public static void main(String[] args) throws InterruptedException {
        Thread readThread1 = new Thread(() -> {
            LOCK.readLock().lock();
            System.out.println("线程一加读锁成功");
            synchronized (LOCK) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            LOCK.readLock().unlock();
            System.out.println("线程一释放读锁成功");
        }, "read-thread-1");
        readThread1.start();
        Thread.sleep(3000L);
        Thread readThread2 = new Thread(() -> {
            LOCK.readLock().lock();
            System.out.println("线程二加读锁成功");
            LOCK.readLock().unlock();
            System.out.println("线程二释放读锁成功");
        }, "read-thread-2");
        readThread2.start();

        Thread writeThread = new Thread(() -> {
            LOCK.writeLock().lock();
            LOCK.writeLock().unlock();
        }, "write-thread");
        //readThread.start();

        //Thread.sleep(200);
        //LOCK.readLock().tryLock();
        readThread1.join();
        readThread2.join();
    }

}
