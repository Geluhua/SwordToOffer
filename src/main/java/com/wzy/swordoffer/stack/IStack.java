package com.wzy.swordoffer.stack;

/**
 * 栈接口
 */
public interface IStack<T> {
    /**
     * 元素出栈，返回出栈元素
     */
    T pop();

    /**
     * 元素入栈
     */
    void push(T element);

    /**
     * 获取栈顶元素
     */
    T peek();

    /**
     * 判断栈是否为空
     */
    boolean isEmpty();

    /**
     * 清空栈
     */
    void clear();
}
