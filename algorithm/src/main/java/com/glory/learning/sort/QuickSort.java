package com.glory.learning.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 快速排序
 *
 * @author Glory
 * @create 2020-07-26 15:58
 **/
public class QuickSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int val = 0;
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(args));

        quickSort(arr, 0, len- 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

    }

}
