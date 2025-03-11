package com.example.leetcodeproblems.recursion;

public class SearchInBinarySearchTree {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(7);
        TreeNode treeNode1 = searchBST(treeNode, 2);
        System.out.println(treeNode1);
    }

    public static TreeNode searchBST(TreeNode root, int val) {

        return treeNode(root, val);
    }

    private static TreeNode treeNode(TreeNode treeNode, int val) {
        if (treeNode == null) {
            return treeNode;
        }

        if (treeNode.val == val) {
            return treeNode;
        }
        if (treeNode.val < val) {
            return treeNode(treeNode.right, val);
        } else {
            return treeNode(treeNode.left, val);
        }
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
