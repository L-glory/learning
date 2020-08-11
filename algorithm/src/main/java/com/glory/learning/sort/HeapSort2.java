package com.glory.learning.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 堆排序
 *
 * 堆化实际上有两种，
 *   1、从上往下
 *   2、从下往上
 * @author Glory
 * @create 2020-07-26 18:35
 **/
public class HeapSort2 {

    private int[] heap;
    private int capacity;
    private int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HeapSort2 heapSort2 = new HeapSort2(n);
        for (int i = 1; i <= n; i++) {
            heapSort2.insert(scanner.nextInt());
        }
        heapSort2.print();
    }

    public HeapSort2(int capacity) {
        // 第一个元素是辅助节点
        heap = new int[capacity + 1];
        this.capacity = capacity;
        this.count = 0;
    }

    /**
     * 大顶推
     * @param elt
     * @return
     */
    public boolean insert(int elt) {
        // 满载
        if (count >= capacity) return false;

        count++;
        heap[count] = elt;

        // 新增元素放在数组末尾，从下往上，重新堆化
        int i = count;
        while (i/2 > 0 && heap[i] > heap[i/2]) {
            int tmp = heap[i];
            heap[i] = heap[i/2];
            heap[i/2] = tmp;
            i = i/2;
        }
        return true;
    }

    public boolean heapify(int n, int i) {
        int maxPos;
        while (true) {

        }
    }

    private void print() {
        System.out.println(Arrays.toString(heap));
    }
}
