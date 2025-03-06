package com.example.leetcodeproblems.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindMinimumInRotatedArray {

    public static void main(String[] args) {

    }

    public static int findMin2(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int middle = left + (right - left) / 2;

            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return nums[left];
    }

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int middle = left + (right - left) / 2;

            if (nums[left] > nums[middle]) {
                right = middle;
            } else if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                return nums[left];
            }

        }
        return nums[left];

    }
}
