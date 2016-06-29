package com.wzy.swordoffer.LeetCode;

import java.util.Scanner;

/**
 * 题目260: Single Number III
 */
public class SingleNumberIII {
    public static int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        // 1. 获取两个不同数字的异或值.
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        if (xor == 0) {
            return null;
        }

        // 2. 获取两个数最后一个不同的位.
        xor &= -xor;

        // 3. 计算结果.
        int res1 = 0, res2 = 0;
        for (int num : nums) {
            if ((xor & num) > 0) {
                res1 ^= num;
            } else {
                res2 ^= num;
            }
        }

        return new int[]{res1, res2};
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String input = cin.nextLine();
            String[] sNums = input.split(",");
            int[] nums = new int[sNums.length];
            for (int i = 0; i < sNums.length; i ++) {
                nums[i] = Integer.valueOf(sNums[i]);
            }

            int[] res = singleNumber(nums);

            System.out.println(res[0] + ":" + res[1]);
        }

        cin.close();
    }
}
