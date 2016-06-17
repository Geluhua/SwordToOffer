package com.wzy.swordoffer.KLeastNumbers;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 面试题30: 最小的k个数.
 */
public class KLeastNumbers {

    private static void createBigHeap(int[] arr, int index, int len) {

        while (index < len) {
            int left = 2 * index + 1;
            int right = left + 1;
            int oldValue = index;

            if (left < len && arr[left] > arr[index]) {
                index = left;
            }

            if (right < len && arr[right] > arr[index]) {
                index = right;
            }

            if (index != oldValue) {
                int tmp = arr[index];
                arr[index] = arr[oldValue];
                arr[oldValue] = tmp;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int[] arr = new int[200001];

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int k = cin.nextInt();
            for (int i = 0; i < n; i ++) {
                arr[i] = cin.nextInt();
            }

            for (int i = (k - 1) / 2; i >= 0; i --) {
                createBigHeap(arr, i, k);
            }

            for (int i = k; i < n; i ++) {
                if (arr[0] > arr[i]) {
                    arr[0] = arr[i];
                    createBigHeap(arr, 0, k);
                }
            }

            int[] res = new int[k];
            System.arraycopy(arr, 0, res, 0, k);
            Arrays.sort(res);

            for (int i = 0; i < k; i ++) {
                if (i == k - 1) {
                    System.out.printf("%d\n", res[i]);
                } else {
                    System.out.printf("%d ", res[i]);
                }
            }
        }

        cin.close();
    }
}
