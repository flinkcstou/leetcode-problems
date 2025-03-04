package com.example.leetcodeproblems.binarysearch;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SplitArrayLargestSum {


    public static void main(String[] args) {
        int i = splitArray2(new int[]{5,4,3,2,1}, 2);
        System.out.println(i);
    }


    public static int splitArray2(int[] nums, int k) {

        int left = IntStream.of(nums).max().getAsInt();
        int right = IntStream.of(nums).sum();

        int res = right;
        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (canSplit(nums, k, middle)) {
                res = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }
        return res;


    }

    public static boolean canSplit(int[] nums, int k, int largest) {

        int subArray = 0;
        int curSum = 0;
        for (int n : nums) {
            curSum += n;
            if (curSum > largest) {
                subArray += 1;
                curSum = n;
            }
        }
        return subArray + 1 <= k;
    }

    public static int splitArray(int[] nums, int k) {

        int left = 0;
        int right = nums.length - 1;
        int sum = IntStream.of(nums).sum();

        int proportion = nums.length / k;

        while ((left < right) && (right - left + 1) >= proportion) {

            int middle = left + (right - left) / 2;
            int leftSum = Arrays.stream(nums).limit(middle + 1).sum();
            int rightSum = sum - leftSum;

            if (leftSum < rightSum) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }


        int leftSum = Arrays.stream(nums).limit(right + 1).sum();
        return Math.max(sum - leftSum, leftSum);
    }
}
