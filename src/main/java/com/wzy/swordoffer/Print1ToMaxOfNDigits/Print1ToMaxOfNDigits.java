package com.wzy.swordoffer.Print1ToMaxOfNDigits;

import java.util.Scanner;

/**
 * 题目12:打印1到最大的n位数
 */
public class Print1ToMaxOfNDigits {
    private static void print1ToMaxN(int n) {
        if (n <= 0) {
            System.out.println(0);
            return;
        }

        char[] nums = new char[n + 1];
        for(int i = 0; i <= n; i ++) {
            nums[i] = '0';
        }

        while (!increment(nums, n)) {
            printNums(nums, n);
        }
    }

    private static void printNums(char[] nums, int n) {
        int ed = n - 1;
        for (; ed >= 0; ed --) {
            if (nums[ed] != '0') {
                break;
            }
        }

        for (int i = ed; i >= 0; i --) {
            System.out.printf("%c", nums[i]);
        }
        System.out.println();
    }

    private static boolean increment(char[] nums, int n) {
        int inc = 1;
        for (int i = 0; i <= n; i ++) {
            if (i == n) {
                return true;
            }
            int num = nums[i] - '0';
            if (num + inc <= 9) {
                nums[i] = (char) (nums[i] + inc);
                break;
            } else {
                int yn = (num + inc) % 10;
                inc = (num + inc) / 10;
                nums[i] = (char) ('0' + yn);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            print1ToMaxN(n);
        }

        cin.close();
    }
}
