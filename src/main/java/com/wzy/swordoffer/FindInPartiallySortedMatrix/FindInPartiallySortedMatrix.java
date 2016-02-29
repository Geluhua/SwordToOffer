package com.wzy.swordoffer.FindInPartiallySortedMatrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个
 * 二维数组和一个整数，判断数组中是否含有该整数。
 * 九度OJ对应题目：http://ac.jobdu.com/problem.php?pid=1384
 */
public class FindInPartiallySortedMatrix {
    private static boolean isFindInPartiallySortedMatrix(int[][] matrix, int m, int n, int value) {
        if (matrix == null) {
            return false;
        }

        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == value) {
                return true;
            } else if (matrix[i][j] > value) {
                j --;
            } else {
                i ++;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(
                new InputStreamReader(System.in)));

        int[][] matrix = new int[1000][1000];

        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            int m = (int) st.nval;
            st.nextToken();

            int n = (int) st.nval;
            st.nextToken();

            int value = (int) st.nval;

            for (int i = 0; i < m; i ++) {
                for (int j = 0; j < n; j ++) {
                    st.nextToken();
                    matrix[i][j] = (int) st.nval;
                }
            }

            boolean isExist = isFindInPartiallySortedMatrix(matrix, m, n, value);
            if (isExist) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

    }
}
