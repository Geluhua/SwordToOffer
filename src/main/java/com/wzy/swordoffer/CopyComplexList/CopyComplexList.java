package com.wzy.swordoffer.CopyComplexList;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 面试题26:复杂链表的复制.
 */
public class CopyComplexList {
    private static class ListNode {
        ListNode next;
        ListNode sibling;
        int val;
        ListNode(int x) {
            this.val = x;
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            ListNode head = new ListNode(Integer.MAX_VALUE);
            ListNode tmpHead = head;
            HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>(n);

            for (int i = 0; i < n; i ++) {
                ListNode node = new ListNode(cin.nextInt());
                tmpHead.next = node;
                tmpHead = tmpHead.next;
                map.put(i + 1, node);
            }

            tmpHead = head;
            while (tmpHead.next != null) {
                int sibling = cin.nextInt();
                tmpHead.next.sibling = map.get(sibling);
                tmpHead = tmpHead.next;
            }

            while (head.next != null) {
                int val = head.next.val;
                int siblingVal = 0;
                if (head.next.sibling != null) {
                    siblingVal = head.next.sibling.val;
                }
                System.out.printf("%d %d\n", val, siblingVal);
                head = head.next;
            }
        }

        cin.close();
    }
}
