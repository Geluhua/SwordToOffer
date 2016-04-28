package com.wzy.swordoffer.ConvertBinarySearchTree_27;

import java.util.Scanner;

/**
 * 面试题27:二叉搜索树与双向链表.
 */
public class ConvertBinarySearchTree {
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        boolean isRoot = true;
    }

    public static void convert(TreeNode root) {

    }

    public static TreeNode createBTree(int[] preOrder, int i) {
        if (preOrder == null || preOrder.length == 0 || i >= preOrder.length || preOrder[i] == 0) {
            return null;
        }

        TreeNode root = new TreeNode();
        root.val = preOrder[i];

        root.left = createBTree(preOrder, i + 1);
        root.right = createBTree(preOrder, i + 2);

        return root;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();


        }

        cin.close();
    }
}
