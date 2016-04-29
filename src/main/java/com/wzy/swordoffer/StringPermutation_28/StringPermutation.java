package com.wzy.swordoffer.StringPermutation_28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 面试题28:字符串的排列.
 */
public class StringPermutation {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            StringBuilder stringBuilder = new StringBuilder(cin.next());
            List<String> res = new ArrayList<String>();

            if (stringBuilder.length() > 0) {
                stringPermutation(stringBuilder, 0, stringBuilder.length() - 1, res);
                Collections.sort(res);
                for (String str : res) {
                    System.out.println(str);
                }
            }

        }

        cin.close();
    }

    private static void stringPermutation(StringBuilder sBuilder, int bt, int ed, List<String> res) {
        if (bt == ed) {
            res.add(sBuilder.toString());
            return;
        }

        for (int k = bt; k <= ed; k++) {
            if (shouldSwap(sBuilder, bt, k)) {
                swap(sBuilder, bt, k);
                stringPermutation(sBuilder, bt + 1, ed, res);
                swap(sBuilder, bt, k);
            }
        }
    }

    private static boolean shouldSwap(StringBuilder sBuilder, int bt, int k) {
        for (int i = bt; i < k; i++) {
            if (sBuilder.charAt(i) == sBuilder.charAt(k)) {
                return false;
            }
        }
        return true;
    }

    private static void swap(StringBuilder sBuilder, int i, int k) {
        char ch = sBuilder.charAt(i);
        sBuilder.setCharAt(i, sBuilder.charAt(k));
        sBuilder.setCharAt(k, ch);
    }
}
