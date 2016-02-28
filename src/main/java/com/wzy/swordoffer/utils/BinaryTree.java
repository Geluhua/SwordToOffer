package com.wzy.swordoffer.utils;

import com.wzy.swordoffer.bean.TreeNode;

/**
 * Created by wzy on 16-2-28.
 */
public class BinaryTree {
    public static <T> TreeNode createBinaryTreeNode(T value) {
        TreeNode<T> treeNode = new TreeNode<>();
        treeNode.left = treeNode.right = null;
        treeNode.value = value;
        return treeNode;
    }

    public static void connectTreeNodes(TreeNode pParent, TreeNode pLeft, TreeNode pRight) {
        if (pParent != null) {
            pParent.left = pLeft;
            pParent.right = pRight;
        }
    }

    public static void destoryTree(TreeNode pRoot) {
        if (pRoot != null) {
            TreeNode pLeft = pRoot.left;
            TreeNode pRight = pRoot.right;

            pRoot = null;
            destoryTree(pLeft);
            destoryTree(pRight);
        }
    }
}
