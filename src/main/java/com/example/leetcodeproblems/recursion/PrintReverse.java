package com.example.leetcodeproblems.recursion;

public class PrintReverse {
    public static void main(String[] args) {
        printReverse();
    }

    private static void printReverse() {
        print(new char[]{'h', 'e', 'l', 'l', 'o'}, 0);
    }

    private static void print(char[] str, int start) {
        if (str == null || start >= str.length) {
            return;
        }
        print(str, start + 1);
        System.out.println(str[start]);
    }

    private static void reverse(char[] str, int left, int right) {
        if (str == null || left >= right) {
            return;
        }

        reverse(str, left + 1, right - 1);

        char leftValue = str[left];
        char rightValue = str[right];
        str[left] = rightValue;
        str[right] = leftValue;
    }
}
