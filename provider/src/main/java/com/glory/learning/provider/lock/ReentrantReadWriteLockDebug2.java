package com.glory.learning.provider.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁debug
 *
 * @author Glory
 * @create 2020-04-25 21:47
 **/
public class ReentrantReadWriteLockDebug2 {

    private static final ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock(false);


    public static void main(String[] args) throws InterruptedException {
        Thread readThread1 = new Thread(() -> {
            LOCK.readLock().lock();
            System.out.println("线程一加读锁成功");
            sleep(3000L);
            LOCK.readLock().unlock();
            System.out.println("线程一释放读锁成功");
        }, "read-thread-1");
        Thread readThread2 = new Thread(() -> {
            LOCK.readLock().lock();
            System.out.println("线程二加读锁成功");
            sleep(3000L);
            LOCK.readLock().unlock();
            System.out.println("线程二释放读锁成功");
        }, "read-thread-2");

        Thread writeThread1 = new Thread(() -> {
            LOCK.writeLock().lock();
            System.out.println("写线程1加写锁成功");
            sleep(3000L);
            LOCK.writeLock().unlock();
            System.out.println("写线程1释放");
        }, "write-thread-1");
        Thread writeThread2 = new Thread(() -> {
            LOCK.writeLock().lock();
            System.out.println("写线程2加写锁成功");
            sleep(3000L);
            LOCK.writeLock().unlock();
            System.out.println("写线程2释放");
        }, "write-thread-2");

        writeThread1.start();
        writeThread2.start();
        Thread.sleep(200L);
        readThread1.start();
        readThread2.start();

        readThread1.join();
        readThread2.join();
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
