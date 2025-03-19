package com.example.leetcodeproblems.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.left.right.left = new TreeNode(6);
        treeNode.left.right.right = new TreeNode(7);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(8);
        treeNode.right.right.left = new TreeNode(9);
        List<List<Integer>> lists = new BinaryTreeLevelOrderTraversal().levelOrderRecursion(treeNode);
        System.out.println(lists);
    }

    public List<List<Integer>> levelOrderRecursion(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        recursion(root, list, 0);
        return list;
    }

    public void recursion(TreeNode treeNode, List<List<Integer>> list, int level) {

        if (treeNode == null) {
            return;
        }

        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(treeNode.val);

        recursion(treeNode.left, list, level + 1);
        recursion(treeNode.right, list, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.addLast(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> listInner = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.removeFirst();
                listInner.add(treeNode.val);
                if (treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
            }

            list.add(listInner);
        }

        return list;
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
