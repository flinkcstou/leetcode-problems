package com.example.leetcodeproblems.other;

public class PalindromeNumber {

    public static void main(String[] args) {

        boolean palindrome = new Solution().isPalindrome(1212);
        System.out.println(palindrome);
    }

    public static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            String palindrome = String.valueOf(x);

            int start = 0;
            int end = palindrome.length() - 1;

            while (start <= end) {

                if (palindrome.charAt(start++) != palindrome.charAt(end--)) {
                    return false;
                }

            }

            return true;
        }
    }
}
