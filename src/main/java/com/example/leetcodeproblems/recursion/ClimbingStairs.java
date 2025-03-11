package com.example.leetcodeproblems.recursion;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static int sum = 0;

    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int i = climbStairs(4);
        System.out.println(i);
    }

    public static int climbStairs(int n) {
        // попробовать решить обычным for loop
        return count(n);
    }

    public static int count(int n) {

        if (n < 2) {
            return 1;
        } else {
            if (map.containsKey(n)) {
                return map.get(n);
            }
            int sum = count(n - 1) + count(n - 2);
            map.put(n, sum);
            return sum;
        }
    }
}
