package com.example.leetcodeproblems.recursion;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        new UniqueBinarySearchTrees().generateTrees(3);
    }

    public List<TreeNode> generateTrees(int n) {

        List<TreeNode> generate = generate(1, n);

        return generate;


    }

    public List<TreeNode> generate(int left, int right) {
        List<TreeNode> trees = new ArrayList<>();
        if (left == right) {
            trees.add(new TreeNode(left));
            return trees;
        } else if (left > right) {
            trees.add(null);
            return trees;
        } else {

            for (int i = left; i <= right; i++) {

                List<TreeNode> leftTrees = generate(left, i - 1);
                List<TreeNode> rightTrees = generate(i + 1, right);

                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = rightTree;
                        trees.add(root);
                    }
                }
            }
            return trees;
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
