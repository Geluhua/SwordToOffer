package com.wzy.swordoffer.PrintListInReverseOrder;

import com.wzy.swordoffer.bean.ListNode;
import com.wzy.swordoffer.utils.List;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目5:输入一个链表的头结点，从尾到头反过来打印每出每一个节点的值
 */
public class PrintListInReverseOrder {
    private static void printByStack(ListNode<Integer> node) {
        if (node== null) {
            return;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        while (node != null) {
            stack.push(node.value);
            node = node.next;
        }

        while (!stack.isEmpty()) {
            System.out.printf("%d ", stack.pop());
        }
        System.out.println();
    }

    private static void printByRecursive(ListNode<Integer> node) {
        if (node == null) {
            return;
        }

        if (node.next != null) {
            printByRecursive(node.next);
        }
        System.out.printf("%d ", node.value);
    }

    public static void main(String[] args) {
        ListNode<Integer> node1 = List.createListNode(1);
        ListNode<Integer> node2 = List.createListNode(2);
        ListNode<Integer> node3 = List.createListNode(3);
        ListNode<Integer> node4 = List.createListNode(4);
        ListNode<Integer> node5 = List.createListNode(5);

        List.connectListNodes(node1, node2, node3, node4, node5);

        System.out.println("Print with stack");
        printByStack(node1);
        System.out.println("Print with Recursive");
        printByRecursive(node1);
        System.out.println();
    }
}
