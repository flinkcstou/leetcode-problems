package com.example.leetcodeproblems.recursion;

import java.util.ArrayDeque;
import java.util.Deque;

public class PathSum {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.right = new TreeNode(1);

        TreeNode treeNode1 = new TreeNode(-2);
        treeNode1.left = null;
        treeNode1.right = new TreeNode(-3);

        boolean b = new PathSum().hasPathSum(treeNode1, -5);
        System.out.println(b);

    }

    public boolean hasPathSumRecursion(TreeNode root, int targetSum) {

        return recursion(root, targetSum);
    }

    public boolean recursion(TreeNode treeNode, int sum) {
        if (treeNode == null) {
            return false;
        }
        sum = sum - treeNode.val;
        if (sum == 0 && treeNode.left == null && treeNode.right == null) {
            return true;
        } else {
            return recursion(treeNode.left, sum) || recursion(treeNode.right, sum);
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        Deque<Integer> dequeSum = new ArrayDeque<>();
        dequeSum.addLast(targetSum);

        while (!deque.isEmpty()) {

            TreeNode treeNode = deque.removeLast();
            Integer sum = dequeSum.removeLast();
            sum = sum - treeNode.val;

            if (sum == 0 && treeNode.left == null && treeNode.right == null) {
                return true;
            }


            if (treeNode.left != null) {
                deque.addLast(treeNode.left);
                dequeSum.addLast(sum);
            }
            if (treeNode.right != null) {
                deque.addLast(treeNode.right);
                dequeSum.addLast(sum);
            }

        }
        return false;

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
