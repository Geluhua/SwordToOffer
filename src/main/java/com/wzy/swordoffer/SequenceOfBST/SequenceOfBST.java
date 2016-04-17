package com.wzy.swordoffer.SequenceOfBST;

import java.util.Scanner;

/**
 * 面试题24:二叉搜索树的后序遍历序列.
 */
public class SequenceOfBST {
    public static boolean verifySequenceOfBST(int[] sequence, int bt, int ed) {
        if (bt >= ed) {
            return true;
        }

        int rightBt;

        for (rightBt = bt; rightBt < ed; rightBt ++) {
            if (sequence[rightBt] > sequence[ed]) {
                break;
            }
        }

        // 判断左子树是否均小于根节点
        for (int i = bt; i < rightBt; i ++) {
            if (sequence[i] > sequence[ed]) {
                return false;
            }
        }

        // 判断右子树是否均大于根节点
        for (int i = rightBt; i < ed; i ++) {
            if (sequence[i] < sequence[ed]) {
                return false;
            }
        }


        return verifySequenceOfBST(sequence, bt, rightBt - 1)
                && verifySequenceOfBST(sequence, rightBt, ed - 1);
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i ++) {
                arr[i] = cin.nextInt();
            }

            boolean res = verifySequenceOfBST(arr, 0, n - 1);
            System.out.println(res ? "Yes" : "No");
        }

        cin.close();
    }
}
