package com.example.leetcodeproblems.binarysearch;

public class PeakElement {


    public static void main(String[] args) {
        int peakElement = findPeakElement(new int[]{1, 3, 2, 1, 1, 1, 1, 5, 7, 2});
        System.out.println(peakElement);
    }

    public static int findPeakElement2(int[] nums) {

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] > nums[middle + 1]) {
                right = middle;

            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    public static int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    public static int binarySearch(int[] nums, int left, int right) {

        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        int leftMiddle = (middle - 1 + (right + 1)) % (right + 1);
        int rightMiddle = (middle + 1 + (right + 1)) % (right + 1);

        if (nums[middle] > nums[leftMiddle] && nums[middle] > nums[rightMiddle]) {
            return middle;
        }
        int i = binarySearch(nums, middle + 1, right);
        if (i != -1) {
            return i;
        }
        return binarySearch(nums, left, middle - 1);
    }
}
