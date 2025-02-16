package com.example.leetcodeproblems.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public static void main(String[] args) {

        int i = 1 + (0 * -1);
        System.out.println(i);

//        findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0);
//        findTargetSumWays(new int[]{1,0}, 1);
//        asdf(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1);
//        findTargetSumWays(new int[]{0}, 0);
    }


    public static int findTargetSumWaysDP(int[] nums, int target) {

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums) {

            Map<Integer, Integer> newDp = new HashMap<>();

            for (int sum : dp.keySet()) {
                int count = dp.get(sum);

                newDp.put(sum + num, dp.getOrDefault(sum + num, count));
                newDp.put(sum - num, dp.getOrDefault(sum - num, count));

            }

            dp = newDp;
        }

        return dp.getOrDefault(target, 0);
    }


    public static int findTargetSumWays(int[] nums, int target) {


        Deque<int[]> deque = new ArrayDeque<>();

        deque.addLast(new int[]{1, target});

        for (int num : nums) {

            int size = deque.size();
            Map<Integer, int[]> map = new HashMap();

            for (int j = 0; j < size; j++) {

                int[] number = deque.removeFirst();

                int sum = number[1] + num;
                int subSum = number[1] - num;

                if (map.containsKey(sum)) {
                    map.get(sum)[0] += map.get(subSum)[0];
                } else {
                    map.put(sum, new int[]{number[0], sum});
                    deque.addLast(map.get(sum));
                }

                if (map.containsKey(subSum)) {
                    map.get(subSum)[0] += map.get(subSum)[0];
                } else {
                    map.put(subSum, new int[]{number[0], subSum});
                    deque.addLast(map.get(subSum));
                }
            }
        }

        return deque.stream().filter(x -> x[1] == 0).findFirst().orElse(new int[]{0})[0];

    }
}


