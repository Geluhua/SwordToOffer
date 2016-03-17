package com.wzy.swordoffer.Fibonacci;

import java.util.Scanner;

/**
 * 面试题9：斐波那契数列
 */
public class Fibonacci {

    private static long[] fibonacci() {
        long[] fib = new long[71];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= 70; i ++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib;
    }

    public static void main(String[] args) {
        long[] fib = fibonacci();

        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            System.out.println(fib[cin.nextInt()]);
        }
        cin.close();
    }
}
