package com.glory.learning.provider.distribution;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * zk分布式锁
 *
 * @author Glory
 * @create 2020-08-06 0:57
 **/
public class ZKDistribLock implements Lock {

    private CuratorFramework client;

    public ZKDistribLock(String host, String namespace) {
        // 客户端初始化
        this.client = CuratorFrameworkFactory.builder()
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .connectString(host)
                .namespace(namespace)
                .build();
        // 客户端启动
        client.start();
    }

    @Override
    public boolean acquire(String key, String val, long millis) throws Exception {
        client.create().creatingParentsIfNeeded().forPath("/lock", "node1".getBytes());
        return false;
    }

    @Override
    public void release(String key, String val) {
    }
}
