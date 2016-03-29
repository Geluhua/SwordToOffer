package com.wzy.swordoffer.KthNodeFromEnd;

import java.util.Scanner;

/**
 * 题目:链表中倒数第K个结点.
 */
@SuppressWarnings({"Convert2Diamond", "unchecked"})
public class KthNodeFromEnd {
    private static class LinkedNode<T> {
        LinkedNode next;
        T value;
    }

    private static void findKthNodeFromEnd(LinkedNode<Integer> header, int n, int k) {
        if (header.next == null || k <= 0 || k > n) {
            System.out.println("NULL");
            return;
        }

        LinkedNode<Integer> first = header.next;
        LinkedNode<Integer> second = header.next;

        while (k > 0) {
            second = second.next;
            k --;
        }

        while (second != null) {
            first = first.next;
            second = second.next;
        }

        System.out.println(first.value);
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int k = cin.nextInt();

            LinkedNode<Integer> header = new LinkedNode<Integer>();
            LinkedNode<Integer> preNode = header;
            for (int i = 0; i < n; i ++) {
                LinkedNode<Integer> node = new LinkedNode<Integer>();
                node.value = cin.nextInt();
                preNode.next = node;
                preNode = node;
            }

            findKthNodeFromEnd(header, n, k);
        }

        cin.close();
    }
}
