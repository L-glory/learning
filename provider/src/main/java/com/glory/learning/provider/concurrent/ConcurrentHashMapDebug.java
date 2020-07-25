package com.glory.learning.provider.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Glory
 * @create 2020-05-05 16:32
 **/
public class ConcurrentHashMapDebug {

    public static void main(String[] args) {
        int n = 32;
        System.out.println(n >>> 2);
        System.out.println(n - (n >>> 2));
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(16);
        map.put("name", "Glory");
    }
}
