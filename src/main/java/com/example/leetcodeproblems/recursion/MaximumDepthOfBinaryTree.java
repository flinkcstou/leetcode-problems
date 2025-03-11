package com.example.leetcodeproblems.recursion;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(15);

        int i = maxDepth(treeNode);
        System.out.println(i);
    }

    public static int maxDepth(TreeNode root) {



        return asd(root);
    }

    public static int asd(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int leftSum = asd(treeNode.left);
        int rightSum = asd(treeNode.right);
        return Math.max(leftSum, rightSum) + 1;
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
