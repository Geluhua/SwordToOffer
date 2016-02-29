package com.wzy.swordoffer.hashmap;

/**
 * 实现一个自定义的HashMap。掌握HashMap的原理：数组+链表，下标为hash，数组元素为链表
 */
public class HashMap<K, V> {
    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;
        int hash;

        Entry(int h, K k, V v, Entry<K, V> n) {
            key = k;
            value = v;
            next = n;
            hash = h;
        }
    }

    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * HashMap中键值对的数量
     */
    private int size = 0;

    /**
     * 装载因子
     */
    float loadFactor;

    /**
     * HashMap的最大阈值，超过该大小需要扩容(该HashMap中暂时不实现该功能)
     */
    int threshold;
    Entry<K, V>[] table;

    public HashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity:" + initialCapacity);
        }

        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }

        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }

        this.loadFactor = loadFactor;

        int capacity = 1;
        while (capacity < initialCapacity) {
            capacity <<= 1;
        }

        this.threshold = (int) (capacity * this.loadFactor);
        table = new Entry[capacity];
    }

    public V put(K key, V value) {
        if (key == null) {
            return putForNullKey(value);
        }

        int hash = key.hashCode();
        int i = hash % table.length;
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }

        addEntry(hash, key, value, i);
        return null;
    }

    public V get(K key) {
        if (key == null) {
            return getForNullKey();
        }

        int hash = key.hashCode();
        int i = hash % table.length;
        for (Entry<K, V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                return e.value;
            }
        }

        return null;
    }

    private V getForNullKey() {
        if (size == 0) {
            return null;
        }

        for (Entry<K, V> entry = table[0]; entry != null; entry = entry.next) {
            if (entry.key == null) {
                return entry.value;
            }
        }
        return null;
    }

    private V putForNullKey(V value) {
        for (Entry<K, V> entry = table[0]; entry != null; entry = entry.next) {
            if (entry.key == null) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }

        addEntry(0, null, value, 0);
        return null;
    }

    private void addEntry(int hash, K key, V value, int bucketIndex) {
        Entry<K, V> oldEntry = table[bucketIndex];
        table[bucketIndex] = new Entry<>(hash, key, value, oldEntry);
        size ++;
    }

    public static void test() {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("111", 2);
        hashMap.put("222", 3);
        hashMap.put("333", 4);
        hashMap.put("444", 2);
        hashMap.put(null, 5);

        System.out.println(hashMap.get("111"));
        System.out.println(hashMap.get("222"));
        System.out.println(hashMap.get("333"));
        System.out.println(hashMap.get("444"));
        System.out.println(hashMap.get(null));
    }

    public static void main(String[] args) {
        test();
    }
}
