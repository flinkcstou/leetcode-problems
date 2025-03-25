package com.example.leetcodeproblems.recursion;

import java.util.ArrayDeque;
import java.util.Deque;

public class SerializeAndDeserializeBinaryTree {


    public static void main(String[] args) {
        //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solutions/74253/easy-to-understand-java-solution/
        // Попробовать решить вот также как тут и понять принцип
        //https://www.youtube.com/watch?v=divtTuSmRFw

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);

        String data = new SerializeAndDeserializeBinaryTree().serialize(treeNode);
        TreeNode deserialize = new SerializeAndDeserializeBinaryTree().deserialize(data);
        TreeNode treeNode1 = deserialize;
    }

    public static Integer parseIntOrNull(String str) {
        if (str == null || str.equalsIgnoreCase("null")) {
            return null;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] split = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);


        int index = 1;

        while (index < split.length) {

            int size = deque.size();

            Integer value = null;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.removeFirst();

                value = parseIntOrNull(split[index++]);
                if (value != null) {
                    treeNode.left = new TreeNode(value);
                    deque.addLast(treeNode.left);
                }
                value = parseIntOrNull(split[index++]);
                if (value != null) {
                    treeNode.right = new TreeNode(value);
                    deque.addLast(treeNode.right);
                }
            }

        }

        return root;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder stringBuilder = levelOrder(root);
        return stringBuilder.toString();
    }

    public StringBuilder levelOrder(TreeNode root) {

        StringBuilder stringBuilder = new StringBuilder();

        if (root == null) {
            return stringBuilder;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        stringBuilder.append(root.val).append(",");

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {

                TreeNode treeNode = deque.removeFirst();
                if (treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }


                stringBuilder.append(treeNode.left == null ? null : treeNode.left.val).append(",");
                stringBuilder.append(treeNode.right == null ? null : treeNode.right.val).append(",");


            }

        }
        return stringBuilder;

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
