package com.wzy.swordoffer.Fibonacci;

import java.util.Scanner;

/**
 * 题目:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 解法：数学归纳法证明f(n)=2^(n-1)
 */
public class AbnormalFrogJump {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();

        long res = (long) Math.pow(2, n - 1);

        System.out.println(res);
        cin.close();
    }
}
