package com.wzy.swordoffer.QueueWithTwoStacks;

import java.util.LinkedList;

/**
 * 题目：用两个栈实现一个队列
 * LeetCode题目地址：https://leetcode.com/problems/implement-queue-using-stacks/
 */
@SuppressWarnings("unused")
public class MyQueue {
    /**
     * 插入栈
     */
    private LinkedList<Integer> stack1 = new LinkedList<>();

    /**
     * 查看栈(ps:该栈不为空时，栈顶元素就是最先入栈的元素)
     */
    private LinkedList<Integer> stack2 = new LinkedList<>();

    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (!stack2.isEmpty()) {
            stack2.pop();
        } else if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack2.pop();
        }
    }

    // Get the front element.
    public int peek() {
        int value = 0;
        if (!stack2.isEmpty()) {
            value = stack2.peek();
        } else if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            value = stack2.peek();
        }
        return value;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
