package com.example.leetcodeproblems.recursion;

import java.util.*;

public class BinaryTreePostOrderTraversal {
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
        new BinaryTreePostOrderTraversal().postorderTraversal(treeNode);
    }

    public List<Integer> postorderTraversalRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list, "root");
        return list;
    }

    public void recursion(TreeNode treeNode, List<Integer> list, String side) {
        if (treeNode == null) {
            return;
        }

        recursion(treeNode.left, list, "left");
        recursion(treeNode.right, list, "right");

        list.add(treeNode.val);

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        // Попробовать решить двумя Stack, решение есть в Solutions
        // Также попробовать решить через variable previous, тоже есть решение в Solutions
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        Set<TreeNode> set = new HashSet<>();
        set.add(null);

        while (!deque.isEmpty()) {
            TreeNode current = deque.getLast();
            if (set.contains(current.right) && set.contains(current.left)) {
                list.add(current.val);
                deque.removeLast();
            }
            if (set.add(current.right)) {
                deque.addLast(current.right);
            }
            if (set.add(current.left)) {
                deque.addLast(current.left);
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
