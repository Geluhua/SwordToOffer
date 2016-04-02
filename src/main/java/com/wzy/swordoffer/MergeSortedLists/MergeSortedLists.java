package com.wzy.swordoffer.MergeSortedLists;

import java.util.Scanner;

/**
 * 题目:合并两个排序的链表.
 */
public class MergeSortedLists {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int m = cin.nextInt();

            ListNode<Integer> p1 = createList(cin, n);
            ListNode<Integer> p2 = createList(cin, m);

            mergeSortedList(p1, p2);
        }

        cin.close();
    }

    private static <T> ListNode<T> createList(Scanner cin, int num) {
        ListNode p = new ListNode();
        ListNode tmp = p;
        for (int i = 0; i < num; i ++) {
            ListNode node = new ListNode();
            node.value = cin.nextInt();
            tmp.next = node;
            tmp = tmp.next;
        }
        return p;
    }

    private static void mergeSortedList(ListNode<Integer> p1, ListNode<Integer> p2) {
        if (p1.next == null && p2.next == null) {
            System.out.println("NULL");
        } else if (p1.next == null || p2.next == null) {
            ListNode<Integer> tmp = p2.next == null ? p1.next : p2.next;
            traverseList(tmp);
        } else {
            ListNode<Integer> tmp1 = p1.next;
            ListNode<Integer> tmp2 = p2.next;
            ListNode<Integer> nHeader = new ListNode<Integer>();
            ListNode<Integer> nTmp = nHeader;
            while (tmp1 != null && tmp2 != null) {
                if (tmp1.value <= tmp2.value) {
                    nTmp.next = tmp1;
                    tmp1 = tmp1.next;
                } else {
                    nTmp.next = tmp2;
                    tmp2 = tmp2.next;
                }
                nTmp = nTmp.next;
            }

            if (tmp1 != null) {
                nTmp.next = tmp1;
            }

            if (tmp2 != null) {
                nTmp.next = tmp2;
            }

            traverseList(nHeader.next);
        }
    }

    private static void traverseList(ListNode<Integer> node) {
        while (node != null) {
            if (node.next == null) {
                System.out.printf("%d\n", node.value);
            } else {
                System.out.printf("%d ", node.value);
            }
            node = node.next;
        }
    }

    private static class ListNode<T> {
        ListNode<T> next;
        T value;
    }
}
