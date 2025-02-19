package com.example.leetcodeproblems.array;

public class GuessGame {


    int guess(int num) {
        return -1;
    }

    public int guessNumber(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {

            int middle = start + (end - start) / 2;

            int guess = guess(middle);

            if (guess == 0) {
                return middle;
            }
            if (guess == -1) {
                end = middle - 1;
            }
            if (guess == 1) {
                start = middle + 1;
            }
        }

        return -1;
    }
}
