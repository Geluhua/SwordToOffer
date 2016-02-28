package com.wzy.swordoffer.bean;

/**
 * Created by wzy on 16-2-28.
 */
public class TreeNode<T> {
    public TreeNode left;
    public TreeNode right;
    public T value;

    public TreeNode() {
        left = right = null;
        value = null;
    }
}
