package com.example.leetcodeproblems.binarysearchtree;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = new Solution().sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    public static class Solution {

        public TreeNode sortedArrayToBSTBest(int[] nums) {
            return recursiveBest(nums, 0, nums.length - 1);
        }

        public TreeNode recursiveBest(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            int middle = start + (end - start) / 2;

            TreeNode root = new TreeNode(nums[middle]);
            root.left = recursiveBest(nums, start, middle - 1);
            root.right = recursiveBest(nums, middle + 1, end);
            return root;
        }

        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new TreeNode();
            }
            TreeNode root = new TreeNode(Integer.MIN_VALUE);
            recursive(root, nums, 0, nums.length - 1);
            return root.right;
        }

        public void recursive(TreeNode root, int[] nums, int start, int end) {
            if (start > end) {
                return;
            }
            int middle = start + (end - start) / 2;
            insert(root, nums[middle]);

            recursive(root, nums, start, middle - 1);
            recursive(root, nums, middle + 1, end);
        }

        public void insert(TreeNode root, int val) {
            if (root.val == val) {
                return;
            }
            if (root.val > val) {
                root.left = root.left != null ? root.left : new TreeNode(val);
                insert(root.left, val);
            } else {
                root.right = root.right != null ? root.right : new TreeNode(val);
                insert(root.right, val);
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
