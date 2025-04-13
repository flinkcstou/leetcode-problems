package com.example.leetcodeproblems.binarysearchtree;

import java.util.ArrayDeque;
import java.util.Deque;

public class InsertIntoABinarySearchTree {

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(7);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);


        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(14);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(17);
        root.right.right.right = new TreeNode(95);


        TreeNode treeNode = new Solution().insertIntoBSTRecursive(root, 4);

        System.out.println(treeNode);


    }

    public static class Solution {

        public TreeNode insertIntoBSTRecursive(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            recursiveBest(root, val);
            return root;
        }

        public void recursiveBest(TreeNode root, int val) {
            if (root.val == val) {
                return;
            } else if (root.val > val) {
                root.left = root.left != null ? root.left : new TreeNode(val);
                recursiveBest(root.left, val);
            } else {
                root.right = root.right != null ? root.right : new TreeNode(val);
                recursive(root.right, val);
            }
        }


        public void recursive(TreeNode root, int val) {
            if (root.val > val) {
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    return;
                }
                recursive(root.left, val);
            } else {
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    return;
                }
                recursive(root.right, val);
            }
        }

        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);

            while (!deque.isEmpty()) {

                TreeNode treeNode = deque.removeLast();

                if (treeNode.val > val) {
                    if (treeNode.left == null) {
                        treeNode.left = new TreeNode(val);
                        break;
                    }
                    deque.addLast(treeNode.left);
                }
                if (treeNode.val < val) {
                    if (treeNode.right == null) {
                        treeNode.right = new TreeNode(val);
                        break;
                    }
                    deque.addLast(treeNode.right);
                }

            }
            return root;

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
