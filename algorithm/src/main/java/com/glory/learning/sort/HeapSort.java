package com.glory.learning.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author Glory
 * @create 2020-04-03 21:45
 **/
public class HeapSort {

    private int[] heap;

    private int capacity;

    private int count;

    public HeapSort(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.heap = new int[]{1, 13, 566, 5, 18, 9, 2, 7};
    }

    public static void main(String[] args) {
       /* String line;
        Scanner scanner = new Scanner(System.in);
        while (!(line = scanner.nextLine()).equalsIgnoreCase("quit")) {

        }*/
        HeapSort sort = new HeapSort(8);
        sort.buildStartMind();
        sort.print();
    }

    public void print() {
        System.out.println(Arrays.toString(this.heap));
    }

    public void buildStartMind() {
        for (int i = capacity / 2; i > 0; --i) {
            heapify(capacity, i);
        }
    }

    public boolean insert(int val) {
        if (count == capacity) {
            return false;
        }

        // 插入堆数组末尾
        heap[++count] = val;

        // 自下向上堆化
        for (int i = count; i/2 > 0 && heap[i] > heap[i/2]; i = i/2) {
           swap(i, i/2);
        }

        return true;
    }

    private void swap(int src, int desc) {
        int tmp = heap[src];
        heap[src] = heap[desc];
        heap[desc] = tmp;
    }

    /**
     * 弹出堆顶元素
     * @return
     */
    public int pop() {
        if (count == 0) {
            return Integer.MIN_VALUE;
        }

        // 弹出元素
        int val = heap[0];

        // 数组最后一个元素，填充到堆顶
        heap[0] = heap[count - 1];

        // 自顶向下堆化
        heapify(count - 1, 0);

        return val;
    }


    private void heapify(int n, int index) {
        while (true) {
            // 初始化为index位置
            int maxPos = index;
            // 父节点小于子节点
            if (index * 2 +1 < n && heap[index] < heap[index * 2]) maxPos = index * 2 + 1;
            if (index * 2 + 2 < n && heap[maxPos] < heap[index * 2 + 2]) maxPos = index * 2 + 2;
            if (maxPos == index) break;
            swap(index, maxPos);
            index = maxPos;
        }
    }
}
