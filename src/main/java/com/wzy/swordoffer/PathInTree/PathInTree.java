package com.wzy.swordoffer.PathInTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 面试题25:二叉树中和为某一值的路径.
 */
public class PathInTree {
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
        boolean isRoot = true;
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode prev = null;
        int count = 0;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                count += root.val;
                root = root.left;
            } else {
                root = stack.pop();
                if (root.right != null && root.right != prev) {
                    // 放回去
                    stack.push(root);
                    root = root.right;
                } else {
                    // 计算count的值
                    if (count == sum && root.left == null && root.right == null) {
                        LinkedList<Integer> linkedList = new LinkedList<Integer>();
                        linkedList.addFirst(root.val);
                        Deque<TreeNode> tmpStack = new ArrayDeque<TreeNode>(stack);
                        while (!tmpStack.isEmpty()) {
                            linkedList.addFirst(tmpStack.pop().val);
                        }
                        list.add(linkedList);
                    }
                    count -= root.val;
                    prev = root;
                    root = null;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int k = cin.nextInt();
            List<TreeNode> treeNodes = new ArrayList<TreeNode>(n);
            for (int i = 0; i < n; i ++) {
                treeNodes.add(new TreeNode(0));
            }

            for (int i = 0; i < n; i ++) {
                TreeNode node = treeNodes.get(i);
                node.val = cin.nextInt();
                int left = cin.nextInt();
                int right = cin.nextInt();
                if (left != -1) {
                    node.left = treeNodes.get(left - 1);
                    treeNodes.get(left - 1).isRoot = false;
                }

                if (right != -1) {
                    node.right = treeNodes.get(right - 1);
                    treeNodes.get(right - 1).isRoot = false;
                }
            }

            TreeNode root = null;
            for (int i = 0; i < n; i ++) {
                if (treeNodes.get(i).isRoot) {
                    root = treeNodes.get(i);
                    break;
                }
            }

            List<List<Integer>> list = pathSum(root, k);

            System.out.println("result:");
            for (int i = 0; i < list.size(); i ++) {
                System.out.printf("%s", "A path is found:");
                List<Integer> childList = list.get(i);
                for (Integer value : childList) {
                    System.out.printf(" %d", value);
                }
                System.out.println();
            }
        }

        cin.close();
    }
}
