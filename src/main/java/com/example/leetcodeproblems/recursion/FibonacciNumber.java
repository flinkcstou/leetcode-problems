package com.example.leetcodeproblems.recursion;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int fib = fib(4);
        System.out.println(fib);
    }

    public static int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if (map.containsKey(N)) {
            return map.get(N);
        }
        int b =  fib(N - 1) + fib(N - 2);
        map.put(N, b);
        return b;
    }
}
