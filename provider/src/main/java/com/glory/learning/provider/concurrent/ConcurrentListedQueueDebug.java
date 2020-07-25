package com.glory.learning.provider.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Glory
 * @create 2020-05-07 23:03
 **/
public class ConcurrentListedQueueDebug {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

}
