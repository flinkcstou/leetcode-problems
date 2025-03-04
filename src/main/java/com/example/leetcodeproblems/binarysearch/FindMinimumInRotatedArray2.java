package com.example.leetcodeproblems.binarysearch;

public class FindMinimumInRotatedArray2 {

    public static void main(String[] args) {
        int min = findMid2(new int[]{2, 2, 2, 0, 2, 2});

    }

    public static int findMid2(int[] nums) {


        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;

            if (nums[left] == nums[middle] && nums[right] == nums[middle]) {
                left++;
                right--;
                continue;
            }

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
        int middle = left + (right - left) / 2;

        if (nums.length > 3 && nums[middle] == nums[left] && nums[middle] == nums[right]) {

            int minus = middle;
            int plus = middle;
            while (minus >= left) {
                if (nums[--minus] != nums[middle]) {
                    right = minus;
                    break;
                }
                if (nums[++plus] != nums[middle]) {
                    left = plus;
                    break;
                }
            }
        }


        while (left < right) {

            middle = left + (right - left) / 2;

            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return nums[left];
    }
}
