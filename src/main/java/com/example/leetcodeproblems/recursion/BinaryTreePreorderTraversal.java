package com.example.leetcodeproblems.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePreorderTraversal {


    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.left.right.left = new TreeNode(6);
        treeNode.left.right.right = new TreeNode(7);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(8);
        treeNode.right.right.left = new TreeNode(9);
        new BinaryTreePreorderTraversal().preorderTraversal(treeNode);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        byStack(root);
        return list;
    }

    public List<Integer> preorderTraversalRecursion(TreeNode root) {
        list = new ArrayList<>();
        recursion(root, "root");
        return list;
    }

    public void byStack(TreeNode treeNode) {

        Deque<TreeNode> deque = new ArrayDeque<>();
        list = new ArrayList<>();

        if (treeNode == null) {
            return;
        }
        deque.addLast(treeNode);

        while (!deque.isEmpty()) {
            TreeNode node = deque.removeLast();
            list.add(node.val);

            if (node.right != null) {
                deque.addLast(node.right);
            }
            if (node.left != null) {
                deque.addLast(node.left);
            }
        }

    }

    public void recursion(TreeNode treeNode, String side) {
        if (treeNode == null) {
            return;
        }
        list.add(treeNode.val);

        recursion(treeNode.left, "left");
        recursion(treeNode.right, "right");
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
