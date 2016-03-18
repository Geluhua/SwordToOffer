package com.wzy.swordoffer.Fibonacci;

import java.util.Scanner;

/**
 * 题目9:矩形覆盖
 */
public class RectangleCover {
    public static void main(String[] args) {
        long[] fibonacci = new long[71];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        fibonacci[2] = 2;
        for (int i = 3; i < 71; i ++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            long res = fibonacci[cin.nextInt()];
            System.out.println(res);
        }

        cin.close();
    }
}
