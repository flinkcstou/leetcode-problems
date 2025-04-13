package com.example.leetcodeproblems.binarysearchtree;

public class DeleteNodeInABST {

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        */

        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        TreeNode treeNode = new Solution().deleteNode(root, 50);
        System.out.println(treeNode);
    }

    public static class Solution {

        public TreeNode getCurrent(TreeNode dump) {
            if (dump.left != null) {
                return dump.left;
            }
            return dump.right;
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            TreeNode dump = new TreeNode(root.val + 1);
            if (root.val > key) {
                dump.left = root;
            } else {
                dump.right = root;
            }
            TreeNode treeNode = find(dump, key);

            if (treeNode == null) {
                return getCurrent(dump);
            }
            TreeNode node = null;
            TreeNode secondNode = null;
            if (treeNode.left != null && treeNode.left.val == key) {
                node = treeNode.left.left;
                secondNode = treeNode.left.right;

                if (node == null) {
                    treeNode.left = secondNode;
                    return getCurrent(dump);
                }
                if (secondNode == null) {
                    treeNode.left = node;
                    return getCurrent(dump);
                }

                while (secondNode.left != null) {
                    secondNode = secondNode.left;
                }
                secondNode.left = node;

                treeNode.left = secondNode;

                return getCurrent(dump);
            }
            if (treeNode.right != null && treeNode.right.val == key) {
                node = treeNode.right.left;
                secondNode = treeNode.right.right;
                if (node == null) {
                    treeNode.right = secondNode;
                    return getCurrent(dump);
                }
                if (secondNode == null) {
                    treeNode.right = node;
                    return getCurrent(dump);
                }

                while (secondNode.left != null) {
                    secondNode = secondNode.left;
                }
                secondNode.left = node;

                treeNode.left = secondNode;
            }


            return getCurrent(dump);


        }


        public TreeNode find(TreeNode root, int key) {
            if (root == null) {
                return null;
            }

            if (root.left != null && root.left.val == key) {
                return root;
            }
            if (root.right != null && root.right.val == key) {
                return root;
            }
            if (root.val > key) {
                return find(root.left, key);
            } else {
                return find(root.right, key);
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
