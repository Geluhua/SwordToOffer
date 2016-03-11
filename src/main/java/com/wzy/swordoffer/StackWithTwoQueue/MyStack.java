package com.wzy.swordoffer.StackWithTwoQueue;

import java.util.ArrayDeque;

/**
 * 题目:用两个队列实现栈
 * LeetCode题目地址：https://leetcode.com/problems/implement-stack-using-queues/
 */
@SuppressWarnings("unused")
public class MyStack {
    private ArrayDeque<Integer> queue1 = new ArrayDeque<>();
    private ArrayDeque<Integer> queue2 = new ArrayDeque<>();

    // Push element x onto stack.
    public void push(int x) {
        queue1.offerLast(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (queue1.size() > 1) {
            queue2.offerLast(queue1.pollFirst());
        }
        // 移除栈顶元素
        queue1.pollFirst();

        // 交换引用
        ArrayDeque<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    // Get the top element.
    public int top() {
        while (queue1.size() > 1) {
            queue2.offerLast(queue1.pollFirst());
        }
        // 查看栈顶元素
        int value = queue1.pollFirst();
        queue2.offerLast(value);

        // 交换引用
        ArrayDeque<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;

        return value;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
