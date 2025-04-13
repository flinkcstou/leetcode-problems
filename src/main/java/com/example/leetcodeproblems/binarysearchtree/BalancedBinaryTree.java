package com.example.leetcodeproblems.binarysearchtree;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        boolean balanced1 = new Solution().isBalanced(root);
        boolean balanced = balanced1;

    }

    public static class Solution {
        public boolean isBalanced(TreeNode root) {
            try {
                recursive(root);
            } catch (Exception e) {
                return false;
            }
            return true;
        }


        public int recursive(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int a = recursive(root.left);
            int b = recursive(root.right);

            int diff = a - b;
            diff = Math.abs(diff);
            if (diff > 1) {
                throw new RuntimeException("over");
            }
            int max = Math.max(a, b);
            return max + 1;

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
