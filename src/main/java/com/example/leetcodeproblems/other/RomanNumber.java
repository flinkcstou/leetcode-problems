package com.example.leetcodeproblems.other;

public class RomanNumber {
    public static void main(String[] args) {
        int i = new Solution().romanToInt("LVIII");
        System.out.println(i);
    }

    public static class Solution {

        public int searchInsert(int[] nums, int target) {

            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int middle = left + (right - left) / 2;

                if (nums[middle] == target) {
                    return target;
                }
                if (nums[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }

            return left;

        }

        public int romanToInt(String s) {
            int sum = 0;

            for (int i = 0; i < s.length(); i++) {

                sum += fun(s.charAt(i));

            }

            return sum;

        }

        public int fun(char c) {
            switch (c) {
                case 'M':
                    return 1000;
                case 'D':
                    return 500;
                case 'C':
                    return 100;
                case 'L':
                    return 50;
                case 'X':
                    return 10;
                case 'V':
                    return 5;
                case 'I':
                    return 1;
                default:
                    return 0;
            }
        }
    }
}
