package com.wzy.swordoffer.Fibonacci;

import java.util.Scanner;

/**
 * 题目:一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法.
 * 解法：跟斐波那契数列一样，f(1)=1, f(2)=2, f(3)=f(1)+f(2),f(n)=f(n-1)+f(n-2)
 */
public class FrogJump {
    private static long[] fibonacci() {
        long[] fib = new long[71];
        fib[0] = 0;
        fib[1] = 1;
        fib[2] = 2;

        for (int i = 3; i <= 70; i ++) {
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
