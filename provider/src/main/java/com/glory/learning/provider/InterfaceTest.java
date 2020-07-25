package com.glory.learning.provider;

/**
 * 接口反射元数据测试
 *
 * @author Glory
 * @create 2020-04-12 0:35
 **/
public class InterfaceTest {

    private String name;

    private int age;

    public InterfaceTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            // do something
            System.out.println("工作线程干活...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "worker-thread-%d");
        // 启动工作线程
        thread.start();
        // main线程等待工作线程die之后，才执行
        thread.join();
        // worker thread is die, main thread continue exe.
        // ...
        System.out.println("工作线程完事，主线程继续");
    }
}
