package com.example.leetcodeproblems.binarysearchtree;

import java.util.ArrayDeque;
import java.util.Deque;

public class LowestCommonAncestorOfABinarySearchTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode treeNode = new Solution().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        System.out.println(treeNode.val);
    }

    public static class Solution {

        Deque<TreeNode> dequeP = new ArrayDeque<>();
        Deque<TreeNode> dequeQ = new ArrayDeque<>();

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            dequeP = new ArrayDeque<>();
            dequeQ = new ArrayDeque<>();

            recursion(dequeP, root, p);
            recursion(dequeQ, root, q);

            TreeNode lowestCommon = root;
            while (!dequeP.isEmpty() && !dequeQ.isEmpty()) {
                TreeNode treeNodeP = dequeP.removeFirst();
                TreeNode treeNodeQ = dequeQ.removeFirst();

                if (treeNodeP.val != treeNodeQ.val) {
                    break;
                }
                lowestCommon = treeNodeP;
            }

            return lowestCommon;

        }

        public void recursion(Deque<TreeNode> deque, TreeNode root, TreeNode target) {
            if (root == null) {
                deque.clear();
                return;
            }

            deque.addLast(root);
            if (root.val == target.val) {
                return;
            }
            if (root.val > target.val) {
                recursion(deque, root.left, target);
            } else {
                recursion(deque, root.right, target);
            }

        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
