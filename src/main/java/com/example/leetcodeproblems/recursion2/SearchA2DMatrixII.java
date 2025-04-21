package com.example.leetcodeproblems.recursion2;

public class SearchA2DMatrixII {
    public static void main(String[] args) {


        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };

        boolean b = new Solution().searchMatrix(matrix, 10);
        System.out.println(b);
    }

    public static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {

            for (int[] ints : matrix) {
                if (binarySearch(ints, target)) {
                    return true;
                }
            }
            return false;

        }


        public boolean binarySearch(int[] arr, int target) {

            int left = 0;
            int right = arr.length - 1;

            if (arr[0] > target || arr[arr.length - 1] < target) {
                return false;
            }


            while (left <= right) {
                int middle = left + (right - left) / 2;

                if (arr[middle] == target) {
                    return true;
                } else if (arr[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }

            }
            return false;

        }


    }
}
