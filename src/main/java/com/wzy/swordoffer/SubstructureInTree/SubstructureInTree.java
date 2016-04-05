package com.wzy.swordoffer.SubstructureInTree;

/**
 * 题目18：树的子结构.
 */
public class SubstructureInTree {
    private static class TreeNode<T> {
        TreeNode<T> left;
        TreeNode<T> right;
        T value;
    }

    private static boolean isSameTree(TreeNode<Integer> t1, TreeNode<Integer> t2) {
        if (t2 == null) {
            return true;
        }

        if (t1 == null) {
            return false;
        }

        if (t1.value != t2.value) {
            return false;
        }

        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

    public static boolean isSubstructureInTree(TreeNode<Integer> root, TreeNode<Integer> t) {
        boolean res = false;

        if (root != null && t != null) {
            if (root.value == t.value) {
                res = isSameTree(root, t);
            }
            if (!res && root.left != null) {
                res = isSubstructureInTree(root.left, t);
            }
            if (!res && root.right != null) {
                res = isSubstructureInTree(root.right, t);
            }
        }

        return res;
    }

}
