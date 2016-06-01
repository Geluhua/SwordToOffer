package com.wzy.swordoffer.MoreThanHalfNumber_29;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 面试题29: 数组中出现次数超过一半的数字
 */
public class MoreThanHalfNumber {
    private static int findMoreThanHalfNumber(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>(n);

        for (int e : arr) {
            if (map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n;
        int[] arr = new int[100001];
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = cin.nextInt();
            for (int i = 0; i < n; i ++) {
                arr[i] = cin.nextInt();
            }

            int element = findMoreThanHalfNumber(arr, n);

            System.out.println(element);
        }

        cin.close();
    }
}
