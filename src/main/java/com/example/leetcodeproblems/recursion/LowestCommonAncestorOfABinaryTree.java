package com.example.leetcodeproblems.recursion;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(node, node.left.left, node.left.right);
    }

    public TreeNode lowestCommonAncestorBest(TreeNode root, TreeNode p, TreeNode q) {

        return recursionBest(root, p, q);
    }

    public TreeNode recursionBest(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = recursionBest(root.left, p, q);
        TreeNode right = recursionBest(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Deque<TreeNode> dequeP = new ArrayDeque<>();
        recursion(dequeP, root, p);

        Deque<TreeNode> dequeQ = new ArrayDeque<>();
        recursion(dequeQ, root, q);

        if (dequeP.isEmpty() || dequeQ.isEmpty()) {
            return root;
        }

        TreeNode lowestCommon = null;

        while (!dequeP.isEmpty() && !dequeQ.isEmpty()) {

            TreeNode asd = dequeP.removeLast();
            TreeNode asd1 = dequeQ.removeLast();
            if (!Objects.equals(asd, asd1)) {
                break;
            }
            lowestCommon = asd;
        }


        return lowestCommon;

    }


    public boolean recursion(Deque<TreeNode> deque, TreeNode root, TreeNode treeNode) {
        if (root == null) {
            return false;
        }
        if (root == treeNode) {
            deque.addLast(root);
            return true;
        }

        if (recursion(deque, root.left, treeNode)) {
            deque.addLast(root);
            return true;
        }
        if (recursion(deque, root.right, treeNode)) {
            deque.addLast(root);
            return true;
        }

        return false;
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
