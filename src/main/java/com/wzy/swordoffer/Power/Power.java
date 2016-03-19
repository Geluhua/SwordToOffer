package com.wzy.swordoffer.Power;

import java.util.Scanner;

/**
 * Created by wzy on 16-3-19.
 */
public class Power {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            for (int i = 0; i < n; i ++) {
                double base = cin.nextDouble();
                int exponent = cin.nextInt();

                pow(base, exponent);
            }
        }


        cin.close();
    }

    private static void pow(double base, int exponent) {
        if (equalsZero(base)) {
            System.out.println("INF");
            return;
        }

        int absExponent = Math.abs(exponent);

        double res = recursivePow(base, absExponent);
        if (exponent < 0) {
            res = 1.00 / res;
        }

        System.out.printf("%.2ef\n", res);
    }

    private static double recursivePow(double base, int exponent) {
        if (exponent == 0) {
            return 1 * 1.00;
        }

        if (exponent == 1) {
            return base * 1.00;
        }

        if ((exponent & 1) == 0) {
            double res = recursivePow(base, exponent >> 1);
            res *= res;
            return res;
        } else {
            double res = recursivePow(base, (exponent - 1) >> 1);
            res *= res;
            res *= base;
            return res;
        }
    }

    private static boolean equalsZero(double num) {
        return num - 0 <= 0.0000001 && num - 0 >= -0.0000001;
    }

}
