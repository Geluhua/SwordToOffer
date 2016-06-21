package com.wzy.swordoffer.NumberOfOne;

import java.util.Scanner;

/**
 * 面试题32:从1到n整数中1出现的次数.
 */
public class NumberOfOne {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int a = cin.nextInt();
            int b = cin.nextInt();

            int res = numberOf1(b) - numberOf1(a);
            System.out.println(res);
        }
        cin.close();
    }

    public static int numberOf1(final int n) {
        return 0;
    }
}
