package com.example.leetcodeproblems.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaximumXOR {
    TrieNode root = new TrieNode();

    public static void main(String[] args) {
        MaximumXOR maximumXOR = new MaximumXOR();
        maximumXOR.findMaximumXOR(new int[]{3,10,5,25,2,8});
        System.out.println(maximumXOR);
    }

    public int findMaximumXORBruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(nums[i] ^ nums[j], max);

            }
        }
        return max;
    }

    public int findMaximumXOR(int[] nums) {
        search(nums);
        return findMax(nums);
    }


    public void search(int[] nums) {


        for (int num : nums) {
            TrieNode curr = root;
            for (int i = 7; i >= 0; i--) {
                int currBit = (num >> i) & 1;
                System.out.println(currBit);
                curr.map.putIfAbsent(currBit, new TrieNode());
                curr = curr.map.get(currBit);
            }
        }
    }

    public int findMax(int[] nums) {
        int max = 0;
        for (int num : nums) {

            TrieNode curr = root;
            int sum = 0;
            for (int i = 7; i >= 0; i--) {
                int currBit = 1 - ((num >> i) & 1);
                if (curr.map.containsKey(currBit)) {
                    sum |= (1 << i);
                    curr = curr.map.get(currBit);
                } else {
                    curr = curr.map.get(1 - currBit);
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static class TrieNode {

        Map<Integer, TrieNode> map = new HashMap<>();


    }
}
