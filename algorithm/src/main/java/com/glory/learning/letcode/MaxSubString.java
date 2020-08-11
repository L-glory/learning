package com.glory.learning.letcode;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 最大字符子串
 * @author Glory
 * @create 2020-07-25 22:53
 **/
public class MaxSubString {
    public static void main(String[] args) {
        String string = RandomStringUtils.randomAlphabetic(30).toLowerCase();
        //String string = "ababcabcd";
        System.out.println(string);

        char[] chars = string.toCharArray();
        int len = string.length();
        int l = 0;
        int r = 0;
        int[] hash = new int[256];
        int maxSubLen = 0;
        while (r < len) {
            if (hash[chars[r]] == 0) {
                hash[chars[r]]++;
                r++;
            }
            // 字符重复
            else {
                hash[chars[l]]--;
                l++;
            }
            maxSubLen = Math.max(maxSubLen, r - l);
        }
        System.out.println("maxSubLen=" + maxSubLen);
    }
}
