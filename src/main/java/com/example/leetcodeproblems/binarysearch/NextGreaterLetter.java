package com.example.leetcodeproblems.binarysearch;

public class NextGreaterLetter {

    public char nextGreatestLetter(char[] letters, char target) {

        int left = 0;
        int right = letters.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;

            int compare = Character.compare(letters[middle], target);
            if (compare <= 0) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        if (letters[left] <= target) {
            return letters[0];
        }
        return letters[left];


    }
}
