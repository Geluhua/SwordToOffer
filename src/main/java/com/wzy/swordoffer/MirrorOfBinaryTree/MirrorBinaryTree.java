package com.wzy.swordoffer.MirrorOfBinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/**
 * 面试题19:二叉树的镜像.
 */
public class MirrorBinaryTree {
    private static class BTNode<T> {
        public BTNode<T> left;
        public BTNode<T> right;
        public T value;
        boolean isRoot = true;
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
        Deque<BTNode<Integer>> stack = new ArrayDeque<BTNode<Integer>>();
        int count = 0;

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                if (count != n - 1) {
                    System.out.printf("%d ", root.value);
                } else {
                    System.out.printf("%d\n", root.value);
                }
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
    }


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            if (n == 0) {
                System.out.println("NULL");
                continue;
            }
            List<BTNode<Integer>> btNodeList = new ArrayList<BTNode<Integer>>();
            for (int i = 0; i < n; i++) {
                BTNode<Integer> btNode = new BTNode<Integer>();
                btNode.value = cin.nextInt();
                btNodeList.add(btNode);
            }

            int left, right;
            for (int i = 0; i < n; i++) {
                char ch = cin.next().trim().charAt(0);
                switch (ch) {
                    case 'd':
                        left = cin.nextInt() - 1;
                        right = cin.nextInt() - 1;
                        btNodeList.get(i).left = btNodeList.get(left);
                        btNodeList.get(i).right = btNodeList.get(right);
                        btNodeList.get(left).isRoot = false;
                        btNodeList.get(right).isRoot = false;
                        break;
                    case 'l':
                        left = cin.nextInt() - 1;
                        btNodeList.get(i).left = btNodeList.get(left);
                        btNodeList.get(left).isRoot = false;
                        break;
                    case 'r':
                        right = cin.nextInt() - 1;
                        btNodeList.get(i).right = btNodeList.get(right);
                        btNodeList.get(right).isRoot = false;
                        break;
                    default:
                        break;
                }
            }

            BTNode<Integer> root = null;
            for (BTNode<Integer> node : btNodeList) {
                if (node.isRoot) {
                    root = node;
                    break;
                }
            }

            mirrorRecursively(root);
            traverseBTree(root, n);
        }

        cin.close();
    }
}
