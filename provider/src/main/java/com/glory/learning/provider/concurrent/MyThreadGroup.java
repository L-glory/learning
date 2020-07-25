package com.glory.learning.provider.concurrent;

/**
 * 线程组测试
 *
 * @author Glory
 * @create 2020-04-12 21:13
 **/
public class MyThreadGroup {

    public static void main(String[] args) {
        ThreadGroup workerGroup = new ThreadGroup("worker");
        Thread  t1 = new Thread(workerGroup, "worker-thread-%d");
        Thread  t2 = new Thread(workerGroup, () -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "worker-thread-%d");
        ThreadGroup currThreadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(currThreadGroup.getName());
        System.out.println(currThreadGroup.getParent().getName());
        System.out.println(workerGroup.getName());
        System.out.println(workerGroup.getParent().getName());

        Runtime.getRuntime().exit(0);
        System.out.println("当前线程ID" + Thread.currentThread().getId());

    }
}
