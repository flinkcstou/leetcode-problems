package com.example.leetcodeproblems.binarysearch;

public class FindFirstAndLastPosition {

    public static void main(String[] args) {
        int[] ints = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);

        System.out.println(ints);
    }

    public static int[] searchRange(int[] nums, int target) {

        // Реши по другому, укажи в while <= и найди значения, и вынеси в функцию while, решение есть в solutions

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1;
        int leftPosition = -1;
        int rightPosition = -1;

        while (left + 1 < right) {

            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                right = middle;
            } else if (nums[middle] < target) {
                left = middle;
            } else {
                right = middle;
            }
        }

        if (nums[left] == target) {
            leftPosition = left;
        }
        if (nums[right] == target && leftPosition == -1) {
            leftPosition = right;
        }


        left = 0;
        right = nums.length - 1;
        while (left + 1 < right) {

            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                left = middle;
            } else if (nums[middle] < target) {
                left = middle;
            } else {
                right = middle;
            }
        }


        if (nums[right] == target) {
            rightPosition = right;
        }
        if (nums[left] == target && rightPosition == -1) {
            rightPosition = left;
        }


        if (leftPosition == -1) {
            leftPosition = rightPosition;
        }
        if (rightPosition == -1) {
            rightPosition = leftPosition;
        }

        return new int[]{leftPosition, rightPosition};
    }
}
