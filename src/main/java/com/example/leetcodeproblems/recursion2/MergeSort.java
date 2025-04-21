package com.example.leetcodeproblems.recursion2;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 5, 1, -4, 10};
        int[] ints = new Solution().mergeSort(arr);
        System.out.println(ints);
    }


    public static class Solution {

        public int[] mergeSort(int[] input) {
            if (input.length <= 1) {
                return input;
            }
            int split = input.length / 2;
            int[] left = mergeSort(Arrays.copyOfRange(input, 0, split));
            int[] right = mergeSort(Arrays.copyOfRange(input, split, input.length));

            return merge(left, right);
        }

        public int[] merge(int[] left, int[] right) {
            int[] current = new int[left.length + right.length];

            int leftPointer = 0;
            int rightPointer = 0;
            int currentPointer = 0;

            while (leftPointer < left.length && rightPointer < right.length) {

                if (left[leftPointer] < right[rightPointer]) {
                    current[currentPointer++] = left[leftPointer++];
                } else {
                    current[currentPointer++] = right[rightPointer++];
                }
            }

            while (leftPointer < left.length) {
                current[currentPointer++] = left[leftPointer++];
            }
            while (rightPointer < right.length) {
                current[currentPointer++] = right[rightPointer++];
            }
            return current;
        }
    }


}
