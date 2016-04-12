package com.wzy.swordoffer.StackPushPopOrder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 面试题22:栈的压入、弹出序列.
 */
public class StackPushPopOrder {
    public static boolean isPopOrder(int n, int[] pushList, int[] popList) {
        if (pushList == null || popList == null) return false;

        boolean res = true;
        Deque<Integer> stack = new ArrayDeque<Integer>(n);
        for (int i = 0; i < n; i ++) {
            int popNum = popList[i];
            if (stack.isEmpty()) {
                // 如果栈为空,则入栈

            }


        }

        return res;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int[] pushList = new int[n];
            int[] popList = new int[n];
            for (int i = 0; i < n; i ++) {
                pushList[i] = cin.nextInt();
            }
            for (int i = 0; i < n; i ++) {
                popList[i] = cin.nextInt();
            }

            boolean res = isPopOrder(n, pushList, popList);
            System.out.println(res ? "Yes" : "No");
        }

        cin.close();
    }
}
