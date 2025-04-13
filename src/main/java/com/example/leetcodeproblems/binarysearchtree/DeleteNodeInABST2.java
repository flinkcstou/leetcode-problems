package com.example.leetcodeproblems.binarysearchtree;

import java.util.Objects;

public class DeleteNodeInABST2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

       /* TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);*/

        TreeNode treeNode = new Solution().deleteNode(root, 7);
        System.out.println(treeNode);
    }

    public static class Solution {

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val == key && root.left == null && root.right == null) {
                return null;
            }


            TreeNode parentNode = new TreeNode(0);
            TreeNode treeNode = find(parentNode, root, key);
            if (treeNode == null) {
                return root;
            }
            delete(parentNode, treeNode, key);
            return root;

        }

        public TreeNode find(TreeNode parentRoot, TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val == key) {
                return root;
            } else if (root.val > key) {
                parentRoot.left = root;
                return find(parentRoot, root.left, key);
            } else {
                parentRoot.left = root;
                return find(parentRoot, root.right, key);
            }
        }

        public void deleteTree(TreeNode deleteNode, TreeNode nextNode) {
            deleteNode.val = nextNode.val;
            deleteNode.left = nextNode.left;
            deleteNode.right = nextNode.right;
        }

        public void delete(TreeNode parentNode, TreeNode deleteNode, int key) {
            TreeNode leftNode = deleteNode.left;
            TreeNode rightNode = deleteNode.right;

            if (leftNode == null && rightNode == null) {
                if (Objects.equals(parentNode.left.left, deleteNode)) {
                    parentNode.left.left = null;
                } else {
                    parentNode.left.right = null;
                }
                return;
            } else if (leftNode == null) {
                deleteTree(deleteNode, rightNode);
                return;
            } else if (rightNode == null) {
                deleteTree(deleteNode, leftNode);
                return;
            }

            TreeNode lastLeftRightNode = rightNode;
            while (lastLeftRightNode.left != null) {
                lastLeftRightNode = lastLeftRightNode.left;
            }
            lastLeftRightNode.left = leftNode;

            deleteTree(deleteNode, rightNode);

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
