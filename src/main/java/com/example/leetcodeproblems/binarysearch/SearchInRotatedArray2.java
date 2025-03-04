package com.example.leetcodeproblems.binarysearch;

public class SearchInRotatedArray2 {

    public static void main(String[] args) {
        boolean search = search(new int[]{1, 0, 1, 1, 1}, 0);

    }

    public static boolean search(int[] nums, int target) {


        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return true;
            } else if (nums[left] == nums[right]) {
                left++;
                right++;
            } else if (nums[left] <= nums[middle]) {
                if (nums[left] <= target && target <= nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else if (nums[middle] <= nums[right]) {
                if (nums[middle] <= target && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return false;
    }
}
