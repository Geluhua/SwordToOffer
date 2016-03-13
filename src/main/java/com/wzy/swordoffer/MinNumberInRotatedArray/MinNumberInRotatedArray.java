package com.wzy.swordoffer.MinNumberInRotatedArray;

import java.util.Scanner;

/**
 * 题目:把一个数组最开始的若干个元素搬到数组的末尾，我们称为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 */
public class MinNumberInRotatedArray {
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int bt = 0, ed = nums.length - 1, mid = bt;

        while (nums[bt] >= nums[ed]) {
            mid = bt + (ed - bt) / 2;

            if (ed - bt == 1) {
                mid = nums[ed] < nums[bt] ? ed : bt;
                break;
            }

            if (nums[bt] == nums[ed]) {
                mid = findMinInOrder(nums, bt, ed);
                break;
            }

            if (nums[mid] < nums[ed]) {
                ed = mid;
            } else {
                bt = mid;
            }
        }

        return nums[mid];
    }

    private static int findMinInOrder(int[] nums, int bt, int ed) {
        int res = bt;
        for (int i = bt + 1; i <= ed; i ++) {
            if (nums[i] < nums[res]) {
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int len = cin.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i ++) {
                arr[i] = cin.nextInt();
            }

            int min = findMin(arr);
            System.out.println(min);
        }


        cin.close();
    }
}