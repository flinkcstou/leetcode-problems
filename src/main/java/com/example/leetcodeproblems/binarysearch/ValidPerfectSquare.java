package com.example.leetcodeproblems.binarysearch;

public class ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {
        // Sqrt(x)  посмотреть реализацию и понять в чем отличается четкое нахождения ответа и приблизительного ответа

        int left = 0;
        int right = num / 2;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            long square = (long) middle * middle;

            if (square == num) {
                return true;
            } else if (square < num) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }


        return false;
    }
}
