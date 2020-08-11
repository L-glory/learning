package com.glory.learning.letcode;

import java.util.Scanner;

/**
 * 两树相加
 * @author Glory
 * @create 2020-07-25 21:31
 **/
public class LinkAdd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node num1 = input(scanner);
        Node num2 = input(scanner);
        System.out.println("=========================");
        print(num1);
        print(num2);
        Node add = add(num1, num2);
        print(add);
    }

    private static Node input(Scanner scanner) {
        Node root = null;
        Node p = null;
        int val;
        while ((val = scanner.nextInt()) > 0 && val < 10) {
            Node node = new Node(val);
            if (root == null) {
                root = node;
                p = node;
            } else {
                p.next = node;
                p = p.next;
            }
        }
        return root;
    }

    /**
     * 两个非负整数按逆序链表储存，每个节点储存一位数字
     * eg：465：5 -> 6 -> 4
     * @param num1
     * @param num2
     */
    private static Node add(Node num1, Node num2) {
        // 进位
        int carried = 0;
        // 结果链表
        Node result = null;
        Node p0 = null;
        Node p1 = num1;
        Node p2 = num2;
        while (p1 != null || p2 != null) {
            int val = carried;
            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }
            val = val % 10;
            carried = val / 10;
            Node node = new Node(val);
            if (result == null) {
                result = node;
                p0 = num1;
            } else {
                p0.next = node;
                p0 = p0.next;
            }
        }

        return result;
    }

    private static void print(Node root) {
        while (root != null) {
            System.out.print(root.val + " --> ");
            root = root.next;
        }
        System.out.println();
    }

    private static class Node {
        private int val;
        private Node pred;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
