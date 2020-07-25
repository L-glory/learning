package com.glory.learning.provider.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Glory
 * @create 2020-05-09 22:26
 **/
public class BlockingArrayQueueDebug {

    public static void main(String[] args) {
        BlockingQueue arrayQueue = new ArrayBlockingQueue(10);
        BlockingQueue linkQueue = new LinkedBlockingQueue(10);
    }
}
