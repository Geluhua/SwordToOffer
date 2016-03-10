package com.wzy.swordoffer.ConstructBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 题目6：根据二叉树的前序序列和中序序列构建二叉树，并写出构建好的二叉树的后序遍历结果
 */
@SuppressWarnings("unused")
public class ConstructBinaryTree {
    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    /**
     * 二叉树非递归前序遍历
     * @param root 二叉树根节点
     */
    public static void preorderTraverse(TreeNode root) {
        TreeNode p = root;
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                // 遍历节点
                System.out.printf("%d ", p.value);
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
        System.out.printf("\n前序遍历结束\n");
    }

    /**
     * 二叉树非递归中序遍历
     * @param root 二叉树根节点
     */
    public static void inorderTraverse(TreeNode root) {
        TreeNode p = root;
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                // 遍历节点
                System.out.printf("%d ", p.value);
                p = p.right;
            }
        }
        System.out.printf("\n中序遍历结束\n");
    }

    /**
     * 二叉树非递归后序遍历
     * @param root 二叉树节点
     */
    public static void postTraverse(TreeNode root) {
        TreeNode p = root;
        TreeNode seeNode = null;
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (p.right != null && p.right != seeNode) {
                    stack.push(p);
                    p = p.right;
                } else {
                    System.out.printf("%d ", p.value);
                    seeNode = p;
                    p = null;
                }
            }
        }
        //System.out.printf("\n后序遍历结束\n");
        System.out.println();
    }

    /**
     * 根据二叉树的前序遍历序列和中序遍历序列构建二叉树
     * @param pre 二叉树前序序列
     * @param in 二叉树中序序列
     * @param len 二叉树节点个数
     * @return 二叉树根节点
     */
    public static TreeNode rebuildTree(ArrayList<Integer> pre, ArrayList<Integer> in, int len) {
        if (pre == null || in == null || len == 0 || pre.size() != in.size() || pre.size() != len ||
                in.size() != len) {
            return null;
        }

        TreeNode root;

        try {
            root = recursiveBTree(pre, in, 0, len, 0);
        } catch (IllegalArgumentException e) {
            root = null;
        }

        return root;
    }

    /**
     * 递归构建二叉树
     * @param pre 前序序列
     * @param in 中序序列
     * @param st 前序序列起始点
     * @param ed 序列结束点
     * @param ist 中序序列起始点
     * @return 二叉树根节点
     */
    private static TreeNode recursiveBTree(ArrayList<Integer> pre, ArrayList<Integer> in,
                                           int st, int ed, int ist) {
        if (st >= ed) return null;

        TreeNode node = new TreeNode();
        node.value = pre.get(st);

        int len = 0;
        while ((ist + len) < ed && pre.get(st) != in.get(ist + len)) {
            len ++;
        }

        if (ist + len >= ed) {
            throw new IllegalArgumentException("数据错误");
        }

        node.left = recursiveBTree(pre, in, st + 1, st + len + 1, ist);
        node.right = recursiveBTree(pre, in, st + len + 1, ed, ist + len + 1);

        return node;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int len = cin.nextInt();
            ArrayList<Integer> preOrders = new ArrayList<>(len);
            ArrayList<Integer> inOrders = new ArrayList<>(len);

            for (int i = 0; i < len; i ++) {
                preOrders.add(cin.nextInt());
            }

            for (int i = 0; i < len; i ++) {
                inOrders.add(cin.nextInt());
            }

            TreeNode root = rebuildTree(preOrders, inOrders, len);
            if (root == null) {
                System.out.println("No");
            } else {
                postTraverse(root);
            }
        }

        cin.close();
    }
}