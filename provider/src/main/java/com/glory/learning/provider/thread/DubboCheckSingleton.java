package com.glory.learning.provider.thread;

/**
 * dubble-check懒汉式单例
 *
 * @author Glory
 * @create 2020-04-18 19:26
 **/
public class DubboCheckSingleton {
    private static volatile DubboCheckSingleton instance;
    private Item item;
    private DubboCheckSingleton() {
        this.item = new Item();
    }
    public static DubboCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DubboCheckSingleton.class) {
                if (instance == null) {
                    /*
                     * 1、new操作不是一个原子操作，会产生多个指令：申请内存，设置instance指针，执行构造方法指令...
                     *   这些指令可能会面临重排，当【设置instance指针】的指令在构造器指令之前完成，会造成其他线程
                     *   拿个一个还没初始化好的instance对象实例；
                     *
                     * 2、因为【设置instance指针】是一个volatile写操作: StoreStore屏障 ->【设置instance指针】 -> StoreLoad屏障
                     * 保证了new操作对象被初始化完事之后，再写入instance指针；
                     */
                    instance = new DubboCheckSingleton();
                }
            }
        }
        return instance;
    }
}
