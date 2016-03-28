package com.wzy.swordoffer.ReorderArray;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目:调整数组顺序使奇数位于偶数前面.
 */
public class ReorderArray {
    /** O(n)时间复杂度. */
    private static void reorderArray(ArrayList<Integer> list) {
        int i = 0, j = list.size() - 1;

        while (i < j) {
            while (i < j && (list.get(i) & 1) == 1) {
                i ++;
            }

            if (i >= j) {
                break;
            }

            while (i < j && (list.get(j) & 1) == 0) {
                j --;
            }
            if (i >= j) {
                break;
            }

            int tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
        }
    }

    /** 调换奇数和偶数的顺序,并保持他们原来的顺序不变. */
    private static void keepReorderArray(ArrayList<Integer> list) {
        ArrayList<Integer> nlist = new ArrayList<>(list.size());

        for (int i = 0; i < list.size(); i ++) {
            if ((list.get(i) & 1) == 1) {
                nlist.add(list.get(i));
            }
        }

        for (int i = 0; i < list.size(); i ++) {
            if ((list.get(i) & 1) == 0) {
                nlist.add(list.get(i));
            }
        }

        for (int i = 0; i < nlist.size(); i ++) {
            if (i == nlist.size() - 1) {
                System.out.printf("%d\n", nlist.get(i));
            } else {
                System.out.printf("%d ", nlist.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>(n);
            for (int i = 0; i < n; i ++) {
                arrayList.add(cin.nextInt());
            }

//            reorderArray(arrayList);
//
//            for (int i = 0; i < arrayList.size(); i ++) {
//                if (i == arrayList.size()) {
//                    System.out.printf("%d\n", arrayList.get(i));
//                } else {
//                    System.out.printf("%d ", arrayList.get(i));
//                }
//            }

            keepReorderArray(arrayList);
        }

        cin.close();
    }
}
