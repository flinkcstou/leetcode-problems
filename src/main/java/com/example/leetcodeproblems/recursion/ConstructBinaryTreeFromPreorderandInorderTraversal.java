package com.example.leetcodeproblems.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderandInorderTraversal {

    public static void main(String[] args) {

        TreeNode treeNode = new ConstructBinaryTreeFromPreorderandInorderTraversal().buildTreeBest(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }

    public TreeNode buildTreeBest(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mapIn = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mapIn.put(inorder[i], i);
        }

        return recursionBest(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, mapIn);
    }

    public TreeNode recursionBest(int[] preorder, int pres, int pree, int[] inorder, int ins, int ine, Map<Integer, Integer> mapIn) {
        if (pres > pree || ins > ine) {
            return null;
        }
        int val = preorder[pres];
        int index = mapIn.get(val);

        int leftSizePreorder = index - ins;

        TreeNode treeNode = new TreeNode(val);
        treeNode.left = recursionBest(preorder, pres + 1, pres + leftSizePreorder, inorder, ins, index - 1, mapIn);
        treeNode.right = recursionBest(preorder, pres +1 + leftSizePreorder, pree, inorder, index + 1, ine, mapIn);
        return treeNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {


        return recursion(preorder, inorder);

    }

    public TreeNode recursion(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> mapIn = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mapIn.put(inorder[i], i);
        }

        int index = 0;
        int val = 0;
        for (int i = 0; i < preorder.length; i++) {
            if (mapIn.containsKey(preorder[i])) {
                index = mapIn.get(preorder[i]);
                val = preorder[i];
                break;
            }
        }


        TreeNode treeNode = new TreeNode(val);

        treeNode.left = recursion(preorder, Arrays.copyOfRange(inorder, 0, index));
        treeNode.right = recursion(preorder, Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return treeNode;
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
