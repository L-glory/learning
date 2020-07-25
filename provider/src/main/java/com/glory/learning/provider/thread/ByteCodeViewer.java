package com.glory.learning.provider.thread;

/**
 * 字节码查看示例
 *
 * @author Glory
 * @create 2020-04-18 14:04
 **/
public class ByteCodeViewer {

    private volatile int flag;

    public ByteCodeViewer(int flag) {
        this.flag = flag;
    }

    public synchronized int incrAndGet() {
        flag++;
        return flag;
    }

    public int addAndGet(int val) {
        synchronized (this) {
            flag += val;
            return flag;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 设置当前线程的中断标志 = true
        Thread.currentThread().interrupt();
        // 线程休眠
        Thread.sleep(200);
    }
}
