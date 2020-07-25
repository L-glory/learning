package com.glory.learning.provider.thread;

/**
 * @author Glory
 * @create 2020-04-17 0:14
 **/
public class SleepThreadTest {

    private boolean done;

    public SleepThreadTest(boolean done) {
        this.done = done;
    }

    public void sleep() {
        while (!this.done) {
            try {
                Thread.sleep(100);
                System.out.println("睡觉");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public static void main(String[] args) throws InterruptedException {
        SleepThreadTest test = new SleepThreadTest(false);
        Thread thread = new Thread(() -> {
            test.sleep();
        }, "sleep thread");
        thread.start();
        Thread.sleep(2000);
        System.out.println("醒醒，姑娘");
        test.setDone(true);
        Thread.sleep(2000);
        System.out.println(String.format("isAlive=%b", thread.isAlive()));
    }
}
