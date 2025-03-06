package com.example.leetcodeproblems.binarysearch;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FindKSmallestPairDistance {


    public static void main(String[] args) {
        int i = smallestDistancePair(new int[]{1, 3, 1}, 1);
        System.out.println(i);
    }

    public static int smallestDistancePair(int[] nums, int k) {

        // завтра решить через binary search, я думаю я вспомню что смотрел на видео и смогу решить;
        // find min pair, find max pair, set middle, and do bruteforce
        int max = IntStream.of(nums).max().getAsInt();

        int[] distance = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int value = Math.abs(nums[j] - nums[i]);
                ++distance[value];
            }
        }
        AtomicInteger sum = new AtomicInteger(0);

        int i = IntStream.range(0, distance.length).filter(it -> sum.addAndGet(distance[it]) >= k).findFirst().orElse(-1);
        return i;


    }
}
