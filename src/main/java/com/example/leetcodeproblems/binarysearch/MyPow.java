package com.example.leetcodeproblems.binarysearch;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyPow {

    public static void main(String[] args) {

        double v = myPow(2.00000, 10);
        System.out.println(v);
    }

    public static double myPow(double x, int n) {

        if (n == 0) {
            return 1.0;
        }

        Deque<Boolean> deque = new ArrayDeque<>();

        long count = Math.abs((long) n);
        while (count > 1) {
            deque.addLast(count % 2 == 1);
            count = count / 2;
        }

        double sum = x;

        while (!deque.isEmpty()) {
            Boolean bool = deque.removeLast();
            if (bool) {
                sum = x * sum * sum;
            } else {
                sum = sum * sum;
            }
        }
        if (n < 0) {
            return 1 / sum;
        } else {
            return sum;
        }
    }
}
