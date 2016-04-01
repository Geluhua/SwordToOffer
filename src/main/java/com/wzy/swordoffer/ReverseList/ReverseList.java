package com.wzy.swordoffer.ReverseList;

import java.util.Scanner;

/**
 * 题目:反转链表
 */
public class ReverseList {
    private static void reverseList(ListNode<Integer> header) {
        if (header.next == null) {
            System.out.println("NULL");
        } else if (header.next.next == null){
            System.out.println(header.next.value);
        } else {
            ListNode<Integer> nPrev = null;
            ListNode<Integer> nCur = header.next;
            ListNode<Integer> nPost = null;

            while (nCur != null) {
                nPost = nCur.next;
                nCur.next = nPrev;
                nPrev = nCur;
                nCur = nPost;
            }
            header.next = nPrev;

            for (ListNode<Integer> inode = header.next; inode != null; inode = inode.next) {
                if (inode.next == null) {
                    System.out.printf("%d\n", inode.value);
                } else {
                    System.out.printf("%d ", inode.value);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();

            // 构造链表
            ListNode<Integer> header = new ListNode<Integer>();
            ListNode<Integer> tmp = header;
            for (int i = 0; i < n; i ++) {
                int value = cin.nextInt();
                ListNode<Integer> node = new ListNode<Integer>();
                node.value = value;
                tmp.next = node;
                tmp = node;
            }

            // 反转链表
            reverseList(header);
        }

        cin.close();
    }

    private static class ListNode<T> {
        ListNode<T> next;
        T value;
    }
}
