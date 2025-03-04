package com.example.leetcodeproblems.binarysearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Set;

public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        OptionalInt first = Arrays.stream(nums)
                .filter(x -> !set.add(x))
                .findFirst();

        return first.orElseGet(() -> -1);

    }
}
