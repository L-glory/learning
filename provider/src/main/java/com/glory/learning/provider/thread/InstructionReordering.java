package com.glory.learning.provider.thread;

/**
 * 指令重排测试
 *
 * @author Glory
 * @create 2020-04-17 23:26
 **/
public class InstructionReordering {

    private static volatile int mark = 0;

    public static void main(String[] args) throws InterruptedException {
        var viewer = new ByteCodeViewer(1);
        var p = new Item();
        var q = p;
        Thread t1 = new Thread(() -> {
            while (mark == 0) Thread.onSpinWait();
            var r1 = p;
            int r2 = r1.x;
            var r3 = q;
            int r4 = r3.x;
            int r5 = r1.x;  // 编译优化，r5 = r2;
            System.out.println(String.format("r2=%d, r4=%d, r5=%d", r2, r4, r5));
        }, "thread-1");
        Thread t2 = new Thread(() -> {
            while (mark == 0) Thread.onSpinWait();
            var r6 = p;
            r6.x = 3;
        }, "thread-2");
        t1.start();
        t2.start();
        Thread.sleep(100);
        mark = 3;
        Thread.sleep(100);
    }

}
