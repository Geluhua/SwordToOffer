package com.wzy.swordoffer.MinInStack;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题21:包含min函数的栈.
 */
public class MinStack {
    private Deque<Integer> mNormalStack = new ArrayDeque<>();
    private Deque<Integer> mMinStack = new ArrayDeque<>();

    public void push(int x) {
        mNormalStack.push(x);
        if (mMinStack.isEmpty() || x <= mMinStack.peek()) {
            mMinStack.push(x);
        }
    }

    public void pop() {
        int x = mNormalStack.pop();
        if (x == mMinStack.peek()) {
            mMinStack.pop();
        }
    }

    public int top() {
        return mNormalStack.peek();
    }

    public int getMin() {
        return mMinStack.peek();
    }
}
