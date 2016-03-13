package com.wzy.swordoffer.Sort;

import java.util.Scanner;

/**
 * 用Java实现各种排序算法
 */
@SuppressWarnings("unused")
public class SortUtils {
    /**
     * 快速排序算法,时间复杂度O(nlogn)
     */
    public static void quickSort(int[] arr, int bt, int ed) {
        if (bt < ed) {
            int pivot = findPivot(arr, bt, ed);
            quickSort(arr, bt, pivot - 1);
            quickSort(arr, pivot + 1, ed);
        }
    }

    private static int findPivot(int[] arr, int bt, int ed) {
        int stand = arr[bt];
        while (bt < ed) {
            while (bt < ed && arr[ed] > stand) {
                ed --;
            }
            if (bt < ed) {
                arr[bt ++] = arr[ed];
            }
            while (bt < ed && arr[bt] < stand) {
                bt ++;
            }
            if (bt < ed) {
                arr[ed --] = arr[bt];
            }
        }
        arr[bt] = stand;
        return bt;
    }

    public static void printArr(int[] arr) {
        for (int num : arr) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }

    /**
     * 冒泡排序,时间复杂度O(n^2)
     */
    public static void bubbleSort(int[] arr, int len) {
        for (int i = 0; i < len - 1; i ++) {
            for (int j = 0; j < len - i - 1; j ++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 插入排序,时间复杂度O(n^2)
     */
    public static void insertSort(int[] arr, int len) {
        for (int i = 1; i < len; i ++) {
            for (int j = i - 1; j >= 0; j --) {
                if (arr[j] < arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 选择排序,时间复杂度O(n^2)
     */
    public static void selectSort(int[] arr, int len) {
        for (int i = 0; i < len - 1; i ++) {
            for (int j = i + 1; j < len; j ++) {
                if (arr[j] < arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    /**
     * 堆排序,时间复杂度O(nlogn)
     */
    public static void heapSort(int[] arr, int len) {
        buildMaxHeap(arr, len);
        for (int i = len - 1; i >= 1; i --) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            maxHeapify(arr, 0, i);
        }
    }

    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = len / 2 - 1; i >= 0; i --) {
            maxHeapify(arr, i, len);
        }
    }

    private static void maxHeapify(int[] arr, int start, int len) {
        while (start < len) {
            int left = 2 * start + 1;
            int right = 2 * start + 2;
            int loc = start;

            if (left < len && arr[left] > arr[start]) {
                start = left;
            }

            if (right < len && arr[right] > arr[start]) {
                start = right;
            }

            if (start != loc) {
                int tmp = arr[start];
                arr[start] = arr[loc];
                arr[loc] = tmp;
            } else {
                break;
            }
        }
    }

    /**
     * 归并排序,时间复杂度O(nlogn)
     */
    public static void mergeSort(int[] arr, int bt, int ed) {
        if (bt < ed) {
            int mid = bt + (ed - bt) / 2;
            mergeSort(arr, bt, mid);
            mergeSort(arr, mid + 1, ed);
            combineArray(arr, bt, mid, ed);
        }
    }

    private static void combineArray(int[] arr, int bt, int mid, int ed) {
        int len = ed - bt + 1;
        if (len <= 0) return;

        int[] newArr = new int[len];
        int i, j, h;
        for (i = bt, j = mid + 1, h = 0; i <= mid && j <= ed; h ++) {
            if (arr[i] <= arr[j]) {
                newArr[h] = arr[i ++];
            } else {
                newArr[h] = arr[j ++];
            }
        }

        while (i <= mid) {
            newArr[h ++] = arr[i ++];
        }

        while (j <= ed) {
            newArr[h ++] = arr[j ++];
        }
        
        System.arraycopy(newArr, 0, arr, bt, newArr.length);
    }


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i ++) {
                arr[i] = cin.nextInt();
            }

            // quickSort(arr, 0, n - 1);
            // bubbleSort(arr, n);
            // selectSort(arr, n);
            // heapSort(arr, n);
            mergeSort(arr, 0, n - 1);
            printArr(arr);
        }

        cin.close();
    }
}
