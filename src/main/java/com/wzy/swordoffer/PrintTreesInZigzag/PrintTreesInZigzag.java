package com.wzy.swordoffer.PrintTreesInZigzag;

import com.wzy.swordoffer.bean.TreeNode;
import com.wzy.swordoffer.utils.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从
 * 左向右的顺序打印，第二层按照从右向左的顺序打印，第三行再按照从左
 * 到右的顺序打印，其他以此类推。
 */
public class PrintTreesInZigzag {
    public void printTreesInZigzag(TreeNode pRoot) {
        // pRoot is null
        if (pRoot == null) {
            System.out.println("pRoot is null");
            return;
        }

        // only proot
        if (pRoot.left == null && pRoot.right == null) {
            System.out.println(pRoot.value);
            return;
        }

        // pRoot is not null and it has many child nodes
        Deque<TreeNode> oddDeque = new ArrayDeque<>();
        Deque<TreeNode> evenDeque = new ArrayDeque<>();
        evenDeque.push(pRoot);

        while (!evenDeque.isEmpty() || !oddDeque.isEmpty()) {
            if (!evenDeque.isEmpty()) {
                while (!evenDeque.isEmpty()) {
                    TreeNode tmpNode = evenDeque.pop();
                    System.out.print(tmpNode.value + " ");
                    if (tmpNode.left != null) {
                        oddDeque.push(tmpNode.left);
                    }

                    if (tmpNode.right != null) {
                        oddDeque.push(tmpNode.right);
                    }
                }
                System.out.println();
            } else {
                while (!oddDeque.isEmpty()) {
                    TreeNode tmpNode = oddDeque.pop();
                    System.out.print(tmpNode.value + " ");
                    if (tmpNode.right != null) {
                        evenDeque.push(tmpNode.right);
                    }
                    if (tmpNode.left != null) {
                        evenDeque.push(tmpNode.left);
                    }
                }
                System.out.println();
            }
        }
    }

    public void test1() {
        TreeNode<Integer> pNode8 = BinaryTree.createBinaryTreeNode(8);
        TreeNode<Integer> pNode6 = BinaryTree.createBinaryTreeNode(6);
        TreeNode<Integer> pNode10 = BinaryTree.createBinaryTreeNode(10);
        TreeNode<Integer> pNode5 = BinaryTree.createBinaryTreeNode(5);
        TreeNode<Integer> pNode7 = BinaryTree.createBinaryTreeNode(7);
        TreeNode<Integer> pNode9 = BinaryTree.createBinaryTreeNode(9);
        TreeNode<Integer> pNode11 = BinaryTree.createBinaryTreeNode(11);

        BinaryTree.connectTreeNodes(pNode8, pNode6, pNode10);
        BinaryTree.connectTreeNodes(pNode6, pNode5, pNode7);
        BinaryTree.connectTreeNodes(pNode10, pNode9, pNode11);

        System.out.println("====Test1 Begins: ====");
        System.out.println("Expected Result is:");
        System.out.println("8");
        System.out.println("10 6");
        System.out.println("5 7 9 11");

        System.out.println("Actual Result is:");
        printTreesInZigzag(pNode8);

        BinaryTree.destoryTree(pNode8);
    }

    

    public static void main(String[] args) {
        PrintTreesInZigzag printTreesInZigzag = new PrintTreesInZigzag();
        printTreesInZigzag.test1();
    }
}
