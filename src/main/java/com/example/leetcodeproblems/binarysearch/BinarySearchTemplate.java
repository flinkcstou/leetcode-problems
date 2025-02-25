package com.example.leetcodeproblems.binarysearch;

public class BinarySearchTemplate {


    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // End Condition: left > right
        return -1;
    }

    public static int binarySearch2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Post-processing:
        // End Condition: left == right
        if (nums[left] == target) return left;
        return -1;
    }

    public static int binarySearch3(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // Post-processing
        // End Condition: left + 1 == right
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }

    public static int search(int[] nums, int target) {


        int head = 0;
        int tail = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            int middle = (tail + head) / 2;

            if (nums[middle] == target) {
                return middle;
            }
            if ((middle + 1) < nums.length && nums[middle + 1] == target) {
                return middle + 1;
            }

            if (nums[middle] < target) {
                head = middle;
            }
            if (nums[middle] > target) {
                tail = middle;
            }
        }


        return -1;
    }
}
