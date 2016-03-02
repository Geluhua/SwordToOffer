package com.wzy.swordoffer.utils;

import com.wzy.swordoffer.bean.ListNode;

/**
 * l链表工具类
 */
public class List {
    public static <T> ListNode<T> createListNode(T value) {
        ListNode<T> node = new ListNode<>();
        node.value = value;
        node.next = null;
        return node;
    }

    public static <T> void connectListNodes(ListNode<T>... nodes) {
        if (nodes != null && nodes.length > 1) {
            for (int i = 0; i < nodes.length - 1; i ++) {
                nodes[i].next = nodes[i + 1];
            }
        }
    }
}
