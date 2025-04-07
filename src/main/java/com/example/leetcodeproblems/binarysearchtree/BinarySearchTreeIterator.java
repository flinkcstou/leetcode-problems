package com.example.leetcodeproblems.binarysearchtree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTreeIterator {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator bstIterator = new BSTIterator(root);

        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }

    }

    public static class BSTIterator {
        // inorderStack можно переписать на две части, первый дойти до левого края, а вторая next продолжить дальше
        // необходимо тебе переписать, несмотря на solutions. Самому вспомнить из головы. переписать и проверить все ли верно написал
        private Deque<Integer> deque = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            inOrderStack(root);
        }

        public void inOrderStack(TreeNode root) {
            deque = new ArrayDeque<>();
            if (root == null) {
                return;
            }
            Deque<TreeNode> dequeStack = new ArrayDeque<>();
            dequeStack.addLast(root);
            TreeNode treeNode = root;

            while (!dequeStack.isEmpty()) {

                while (treeNode != null && treeNode.left != null) {
                    dequeStack.addLast(treeNode.left);
                    treeNode = treeNode.left;
                }
                TreeNode child = dequeStack.removeLast();
                deque.addLast(child.val);
                if (child.right != null) {
                    dequeStack.addLast(child.right);
                    treeNode = child.right;
                }
            }


        }

        public void inOrder(TreeNode root) {
            deque = new ArrayDeque<>();
            inOrderRecursive(root);
        }

        public void inOrderRecursive(TreeNode root) {
            if (root == null) {
                return;
            }

            inOrderRecursive(root.left);
            deque.addLast(root.val);
            inOrderRecursive(root.right);
        }

        public int next() {
            if (deque.isEmpty()) {
                return -1;
            }
            return deque.removeFirst();
        }

        public boolean hasNext() {
            return !deque.isEmpty();
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
