package com.wzy.swordoffer.Cache;

import java.util.HashMap;

/**
 * LRU缓存算法实现.
 */
@SuppressWarnings("unused")
public class LRUCache {
    private final int mCapacity;
    private int mCurrentNum;
    private HashMap<Integer, DoubleLinkedList<Integer>> mHashMap;
    private DoubleLinkedList<Integer> mHeader;

    public LRUCache(int capacity) {
        mCapacity = capacity;
        mCurrentNum = 0;
        mHeader = new DoubleLinkedList<>();
        mHashMap = new HashMap<>();
    }

    public int get(int key) {
        if (mHashMap.containsKey(key)) {
            DoubleLinkedList<Integer> node = mHashMap.get(key);
            // Move node to head
            if (node.prev == mHeader) {
                // do nothing, already the first node
            } else if (node.next == mHeader) {
                // is the last node
                node.prev.next = mHeader;
                mHeader.prev = node.prev;
                mHeader.next.prev = node;
                node.next = mHeader.next;
                node.prev = mHeader;
                mHeader.next = node;
            } else {
                // is the middle node
                node.prev.next = node.next;
                node.next.prev = node.prev;
                mHeader.next.prev = node;
                node.next = mHeader.next;
                node.prev = mHeader;
                mHeader.next = node;
            }
            return node.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        DoubleLinkedList<Integer> node = null;
        if (mHashMap.containsKey(key)) {
            node = mHashMap.get(key);
        }

        if (node == null) {
            // new node
            node = new DoubleLinkedList<>();
            node.value = value;
            mCurrentNum ++;
            if (mCurrentNum > mCapacity) {
                // delete node from end
                if (mHeader.prev != null && mHeader.prev != mHeader) {
                    mHashMap.remove(mHeader.prev.key);
                    mHeader.prev.prev.next = mHeader;
                    mHeader.prev = mHeader.prev.prev;
                }
                mCurrentNum --;
            }
            // insert new node
            mHeader.next.prev = node;
            node.next = mHeader.next;
            node.prev = mHeader;
            mHeader.next = node;
            node.key = key;
        } else {
            // exist node, change node value and move node to head
            node.value = value;
            if (node.prev == mHeader) {
                // do nothing, already the first node
            } else if (node.next == mHeader) {
                // is the last node
                node.prev.next = mHeader;
                mHeader.prev = node.prev;
                mHeader.next.prev = node;
                node.next = mHeader.next;
                node.prev = mHeader;
                mHeader.next = node;
            } else {
                // is the middle node
                node.prev.next = node.next;
                node.next.prev = node.prev;
                mHeader.next.prev = node;
                node.next = mHeader.next;
                node.prev = mHeader;
                mHeader.next = node;
            }
        }
        mHashMap.put(key, node);
    }

    private static class DoubleLinkedList<T> {
        DoubleLinkedList<T> prev;
        DoubleLinkedList<T> next;
        int key;
        T value;
        public DoubleLinkedList() {
            prev = next = this;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.set(2, 6);
        lruCache.get(1);
        lruCache.set(1, 5);
        lruCache.set(1, 2);
        lruCache.get(1);
        lruCache.get(2);
    }
}
