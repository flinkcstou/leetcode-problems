package com.example.leetcodeproblems.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BynaryTreeInOrderTraversal {
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

        List<Integer> integers = new BynaryTreeInOrderTraversal().inorderTraversalRecursion(treeNode);
        System.out.println(integers);

    }
    public List<Integer> inorderTraversalRecursion(TreeNode root){
        List<Integer> integers = new ArrayList<>();
        recursion(root, integers, "root");
        return integers;
    }

    public void recursion(TreeNode treeNode, List<Integer> list, String side) {
        if (treeNode == null) {
            return;
        }
        recursion(treeNode.left, list, "left");
        list.add(treeNode.val);
        recursion(treeNode.right, list, "right");
    }

    public List<Integer> inorderTraversalBest(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode current = root;

        while (current != null || !deque.isEmpty()) {
            while (current != null) {
                deque.addLast(current);
                current = current.left;
            }

            TreeNode treeNode = deque.removeLast();
            list.add(treeNode.val);
            current = treeNode.right;
        }

        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        TreeNode treeNode = root;

        while (!deque.isEmpty()) {
            while (treeNode != null && treeNode.left != null) {
                deque.addLast(treeNode.left);
                treeNode = treeNode.left;
            }
            TreeNode treeNode1 = deque.removeLast();
            list.add(treeNode1.val);
            if (treeNode1.right != null) {
                deque.addLast(treeNode1.right);
                treeNode = treeNode1.right;
            }

        }

        return list;
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
