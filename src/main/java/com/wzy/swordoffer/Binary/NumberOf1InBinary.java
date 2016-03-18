package com.wzy.swordoffer.Binary;

import java.util.Scanner;

/**
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 */
public class NumberOf1InBinary {
    private static int numberOf1(int n) {
        if (n == 0) {
            return 0;
        }

        int res = 0;
        while (n != 0) {
            res ++;
            n = n & (n - 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int t = cin.nextInt();
            for (int i = 0; i < t; i ++) {
                int res = numberOf1(cin.nextInt());
                System.out.println(res);
            }
        }

        cin.close();
    }
}
