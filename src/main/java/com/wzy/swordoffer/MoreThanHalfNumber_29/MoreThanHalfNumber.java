package com.wzy.swordoffer.MoreThanHalfNumber_29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 面试题29: 数组中出现次数超过一半的数字
 */
public class MoreThanHalfNumber {
    /**
     * 使用HashMap,时间复杂度O(N),空间复杂度O(N).
     */
    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0, n = nums.length; i < n; i ++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }

    /**
     * 分析数组结构,时间复杂度O(N),空间复杂度O(1).
     */
    public static int majorityElement2(int[] nums) {
        int res = nums[0], occur = 0;

        for (int i = 1, n = nums.length; i < n; i ++) {
            if (occur == -1) {
                res = nums[i];
                occur = 0;
                continue;
            }

            if (nums[i] == res) {
                occur ++;
            } else {
                occur --;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int n;
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = cin.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i ++) {
                nums[i] = cin.nextInt();
            }

            int element = majorityElement2(nums);

            System.out.println(element);
        }

        cin.close();
    }
}
