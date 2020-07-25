package com.glory.learning.provider.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier调试
 *
 * @author Glory
 * @create 2020-05-05 0:47
 **/
public class CyclicBarrierDebug {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("[barrier-command] all worker done, execute barrier's command");
        });

        Thread worker1 = new Thread(() -> {
            System.out.println("[worker-thread-1] finish work, waiting all worker-thread done.");
            try {
                Thread.sleep(1000L);
                barrier.await();
                System.out.println("[worker-thread-1] all worker done, exist.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread worker2 = new Thread(() -> {
            System.out.println("[worker-thread-2] finish work, waiting all worker-thread done.");
            try {
                Thread.sleep(500L);
                barrier.await();
                System.out.println("[worker-thread-2] all worker done, exist.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread worker3 = new Thread(() -> {
            System.out.println("[worker-thread-3] finish work, waiting all worker-thread done.");
            try {
                Thread.sleep(800L);
                barrier.await();
                System.out.println("[worker-thread-3] all worker done, exist.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        worker3.start();
        worker1.start();
        worker2.start();
        while (Thread.activeCount() > 2) {
            Thread.onSpinWait();
        }
    }
}
