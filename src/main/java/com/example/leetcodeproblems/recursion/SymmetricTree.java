package com.example.leetcodeproblems.recursion;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        boolean symmetric = new SymmetricTree().isSymmetricOtherWay(treeNode);
        System.out.println(symmetric);
    }

    public boolean isSymmetricOtherWay(TreeNode root) {
        return recursion(root, root);
    }

    public boolean recursion(TreeNode treeNodeLeft, TreeNode treeNodeRight) {
        if (treeNodeLeft == null && treeNodeRight == null) {
            return true;
        }
        if (treeNodeLeft == null || treeNodeRight == null) {
            return false;
        }
        return treeNodeLeft.val == treeNodeRight.val && recursion(treeNodeLeft.left, treeNodeRight.right) && recursion(treeNodeRight.left, treeNodeLeft.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null || root.right == null) {
            return false;
        }
        List<Integer> listLeft = new ArrayList<>();
        recursionLeft(root.left, listLeft);

        List<Integer> listRight = new ArrayList<>();
        recursionRight(root.right, listRight);


        return listLeft.equals(listRight);
    }


    public void recursionLeft(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }

        list.add(treeNode.val);
        recursionLeft(treeNode.left, list);
        recursionLeft(treeNode.right, list);

    }

    public void recursionRight(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        list.add(treeNode.val);
        recursionRight(treeNode.right, list);
        recursionRight(treeNode.left, list);
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
