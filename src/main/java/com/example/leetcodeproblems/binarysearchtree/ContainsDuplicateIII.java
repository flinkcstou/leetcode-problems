package com.example.leetcodeproblems.binarysearchtree;

import java.util.*;

public class ContainsDuplicateIII {
    public static void main(String[] args) {


        boolean b = new Solution().containsNearbyAlmostDuplicate(new int[]{-2, 3}, 4, 5);
        boolean b1 = b;
    }

    public static class Solution {

        public boolean containsNearbyAlmostDuplicateBest(int[] nums, int indexDiff, int valueDiff) {

            TreeSet<Long> treeSet = new TreeSet<>();

            for (int i = 0; i < nums.length; i++) {

                long num = nums[i];

                if (i > indexDiff) {
                    treeSet.remove((long) nums[i - indexDiff - 1]);
                }

                Long floor = treeSet.floor(num + valueDiff);

                if (floor != null && floor >= nums[i] - valueDiff) {
                    return true;
                }

                treeSet.add(num);

            }

            return false;


        }

        public boolean containsNearbyAlmostDuplicate(int[] numsOrigin, int indexDiff, int valueDiff) {
            if (numsOrigin == null || numsOrigin.length <= 1) {
                return false;
            }
            Map<Integer, List<Integer>> map = new HashMap<>();
            Set<Integer> set = new TreeSet<>();

            for (int i = 0; i < numsOrigin.length; i++) {
                map.putIfAbsent(numsOrigin[i], new ArrayList<>());
                map.get(numsOrigin[i]).add(i);

                set.add(numsOrigin[i]);
            }

            int[] nums = new int[set.size()];
            int l = 0;
            for (Integer i1 : set) {
                nums[l++] = i1;
            }


            for (int i = 0; i < nums.length; i++) {
                asd:
                for (int j = i; j < nums.length; j++) {

                    int diff = nums[j] - nums[i];
                    if (diff <= valueDiff) {
                        if (nums[j] == nums[i]) {
                            List<Integer> integers = map.get(nums[j]);
                            if (integers.size() < 2) {
                                continue;
                            }
                            for (int k = 1; k < integers.size(); k++) {
                                if (Math.abs(integers.get(k) - integers.get(k - 1)) <= indexDiff) {
                                    return true;
                                }
                            }
                        } else {
                            List<Integer> integersI = map.get(nums[i]);
                            List<Integer> integersJ = map.get(nums[j]);
                            asd2:
                            for (int k = 0; k < integersI.size(); k++) {
                                if (integersJ.size() <= k) {
                                    break asd2;
                                }
                                if (Math.abs(integersI.get(k) - integersJ.get(k)) <= indexDiff) {
                                    return true;
                                }
                            }
                        }

                        map.get(nums[j]);
                    } else {
                        break asd;
                    }
                }
            }

            return false;
        }
    }
}
