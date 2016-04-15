package com.wzy.swordoffer.PrintTreeFromTopToBottom;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/**
 * 面试题23:从上往下打印二叉树.
 */
public class LevelTraverseTree {
    private static class TreeNode<T> {
        TreeNode<T> left;
        TreeNode<T> right;
        T value;
        boolean isRoot = true;
    }

    public static void traverseBTree(TreeNode<Integer> root, int n) {
        if (root == null) {
            return;
        }
        Deque<TreeNode<Integer>> queue = new ArrayDeque<TreeNode<Integer>>(n);
        queue.addLast(root);

        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            if (count == n - 1) {
                System.out.printf("%d\n", node.value);
            } else {
                System.out.printf("%d ", node.value);
            }
            count ++;

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
            List<TreeNode<Integer>> list = new ArrayList<TreeNode<Integer>>(n);
            for (int i = 0; i < n; i ++) {
                TreeNode<Integer> node = new TreeNode<Integer>();
                node.value = cin.nextInt();
                list.add(node);
            }

            int left, right;
            for (int i = 0; i < n; i ++) {
                char ch = cin.next().trim().charAt(0);
                switch (ch) {
                    case 'd':
                        left = cin.nextInt();
                        right = cin.nextInt();
                        list.get(i).left = list.get(left - 1);
                        list.get(i).right = list.get(right - 1);
                        list.get(left - 1).isRoot = false;
                        list.get(right - 1).isRoot = false;
                        break;
                    case 'l':
                        left = cin.nextInt();
                        list.get(i).left = list.get(left - 1);
                        list.get(left - 1).isRoot = false;
                        break;
                    case 'r':
                        right = cin.nextInt();
                        list.get(i).right = list.get(right - 1);
                        list.get(right - 1).isRoot = false;
                        break;
                    default:
                        break;
                }
            }

            TreeNode<Integer> root = null;
            for (TreeNode<Integer> node : list) {
                if (node.isRoot) {
                    root = node;
                    break;
                }
            }

            traverseBTree(root, n);
        }

        cin.close();
    }
}
