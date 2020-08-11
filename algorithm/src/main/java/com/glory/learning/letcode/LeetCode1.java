package com.glory.learning.letcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author Glory
 * @create 2020-07-26 14:33
 **/
public class LeetCode1 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,8,12,22,10,5,7,2,14,40,36,18};
        int target = 16;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int key = target - current;
            if (indexMap.containsKey(key)) {
                System.out.println(String.format("[%d, %d]", indexMap.get(key), i));
                break;
            } else {
                indexMap.put(current, i);
            }
        }
    }
}
