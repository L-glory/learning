package com.glory.learning.provider.distribution;

/**
 * @author Glory
 * @create 2020-08-06 0:57
 **/
public interface Lock {

    boolean acquire(String key, String val, long millis) throws Exception;

    void release(String key, String val);
}
