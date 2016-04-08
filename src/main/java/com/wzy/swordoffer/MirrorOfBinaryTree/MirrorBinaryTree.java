package com.wzy.swordoffer.MirrorOfBinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 面试题19:二叉树的镜像.
 */
public class MirrorBinaryTree {
    private static class BTNode<T> {
        public BTNode<T> left;
        public BTNode<T> right;
        public T value;
    }

    public static <T> void mirrorRecursively(BTNode<T> node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        BTNode<T> tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        if (node.left != null) {
            mirrorRecursively(node.left);
        }

        if (node.right != null) {
            mirrorRecursively(node.right);
        }
    }

    private static void traverseBTree(BTNode<Integer> root, int n) {
        Deque<BTNode<Integer>> queue = new ArrayDeque<BTNode<Integer>>();
        if (root != null) {
            queue.addLast(root);
        }

        while (!queue.isEmpty()) {
            BTNode<Integer> node = queue.pollFirst();
            System.out.printf("%d ", node.value);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
    }


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i ++) {
                array[i] = cin.nextInt();
            }

            if (n <= 0) {
                System.out.println("NULL");
            } else {
                BTNode<Integer> btRoot = new BTNode<Integer>();
            }
        }

        cin.close();
    }
}
