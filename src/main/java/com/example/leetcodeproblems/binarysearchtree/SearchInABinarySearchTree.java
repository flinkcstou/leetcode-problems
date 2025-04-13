package com.example.leetcodeproblems.binarysearchtree;

import java.util.ArrayDeque;
import java.util.Deque;

public class SearchInABinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode treeNode = new Solution().searchBST(root, 2);
        System.out.println(treeNode);
    }

    public static class Solution {
        public TreeNode searchBSTStack(TreeNode root, int val) {
            if (root == null) {
                return null;
            }

            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);

            while (!deque.isEmpty()) {
                TreeNode treeNode = deque.removeLast();

                if (treeNode.val == val) {
                    return treeNode;
                }
                if (treeNode.left != null && treeNode.val > val) {
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null && treeNode.val < val) {
                    deque.addLast(treeNode.right);
                }

            }

            return null;

        }

        public TreeNode searchBST(TreeNode root, int val) {

            return recursive(root, val);
        }

        public TreeNode recursive(TreeNode root, int val) {
            if (root == null) {
                return root;
            }
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                return recursive(root.left, val);
            } else {
                return recursive(root.right, val);
            }
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
