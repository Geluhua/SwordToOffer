package com.wzy.swordoffer.bean;

/**
 * 泛型二叉树
 */
public class TreeNode<T> {
    public TreeNode<T> left;
    public TreeNode<T> right;
    public T value;

    public TreeNode() {
        left = right = null;
        value = null;
    }
}
