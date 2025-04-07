package com.example.leetcodeproblems.binarysearchtree;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);

        boolean validBST = new Solution().isValidBSTRecursive(root);
        System.out.println(validBST);
    }

    public static class Solution {


        public boolean isValidBSTRecursive(TreeNode root) {

            return recursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE, "root");

        }

        public boolean recursive(TreeNode root, int minimum, int maximum, String side) {
            if (root == null) {
                return true;
            }
            if (root.val > minimum && root.val < maximum) {
                return true;
            }
            return recursive(root.left, minimum, root.val, "left") && recursive(root.right, root.val, maximum, "right");
        }

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return false;
            }
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);

            while (!deque.isEmpty()) {
                TreeNode treeNode = deque.removeLast();

                if (treeNode.left != null) {
                    if (treeNode.val <= treeNode.left.val) {
                        return false;
                    }
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    if (treeNode.val >= treeNode.right.val) {
                        return false;
                    }
                    deque.addLast(treeNode.right);
                }
            }
            return true;
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
