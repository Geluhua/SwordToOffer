package com.wzy.swordoffer.stack;


import java.util.Arrays;

@SuppressWarnings("unchecked")
public class ArrayStack<T> implements IStack<T> {
    private static final int DEFAULT_SIZE = 3;
    private static final int MAX_SIZE = 1 << 30;

    private Object[] array;
    private int size;
    private int capacity;
    private int initialCapacity = -1;

    public ArrayStack() {
        this.capacity = DEFAULT_SIZE;
        this.size = 0;
        this.array = new Object[this.capacity];
    }

    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            capacity = DEFAULT_SIZE;
        }

        if (capacity > MAX_SIZE) {
            capacity = MAX_SIZE;
        }

        this.capacity = capacity;
        this.size = 0;
        this.array = new Object[this.capacity];
        this.initialCapacity = this.capacity;
    }

    @Override
    public T pop() {
        if (this.size > 0) {
            T element = (T) array[this.size - 1];
            size --;
            return element;
        } else {
            return null;
        }
    }

    @Override
    public void push(T element) {
        if (size < capacity) {
            array[size ++] = element;
        } else {
            resize();
            push(element);
        }
    }

    @Override
    public T peek() {
        if (this.size > 0) {
            return (T) array[this.size - 1];
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
        capacity = initialCapacity == -1 ? DEFAULT_SIZE : initialCapacity;
        array = new Object[capacity];
    }

    private void resize() {
        capacity = 2 * capacity;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        Arrays.fill(array, null);
        array = newArray;
    }

    public static  <T> void printStack(ArrayStack<T> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        printStack(stack);
    }
}
